package day0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281_야구 {
	
	public static int N, tempTurn[], turn[], inning[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		inning = new int[N][10];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		tempTurn = new int[8];	// 4번타자는 빼고 순서를 정함
		for (int i = 1; i < 9; i++) {	// 4번 타자는 1번 선수니까 빼고 설정
			tempTurn[i-1] = i+1;
		}
		
		int result = 0;
		turn = new int[9];
		
		//순서 정하기
		do {
			for (int i = 0; i < 3; i++) {
				turn[i] = tempTurn[i];
			}
			turn[3] = 1;
			for (int i = 4; i < 9; i++) {
				turn[i] = tempTurn[i-1];
			}
			result = Math.max(result, baseball());
			
		}while(np());

		System.out.println(result);
		
		
	}
	
	public static boolean np() {
		int i = 8-1;
		while(i>0 && tempTurn[i-1] >= tempTurn[i]) i--;
		
		if(i == 0) return false;
		
		// i-1 값이 바꿀 값이고, 그거와 바꿀 위치 결정
		int j = 8-1;
		
		while(j>0 && tempTurn[j] < tempTurn[i-1]) j--;

		int temp = tempTurn[i-1];
		tempTurn[i-1] = tempTurn[j];
		tempTurn[j] = temp;
		
		
		// i 이후의 값들 리버스 해줌
		int z = 8-1;
		while(i < z) {
			temp = tempTurn[i];
			tempTurn[i] = tempTurn[z];
			tempTurn[z] = temp;
			z--;
			i++;
		}
		return true;
	}
	
	public static int baseball() {
		int curPlayer = 0;
		int outCnt = 0;
		int score = 0;

		// 이닝의 수만큼 반복
		for (int i = 0; i < N; i++) {
			int base1 = 0;
			int base2 = 0;
			int base3 = 0;
			
			while(outCnt < 3) {
				int r = inning[i][turn[curPlayer]];
				if(r == 0) outCnt++;
				else if(r==1) {
					score += base3;
					base3 = base2;
					base2 = base1;
					base1 = 1;
				}else if(r==2) {
					score += base3+base2;
					base3 = base1;
					base2 = 1;
					base1 = 0;
				}else if(r==3) {
					score += base3+base2+base1;
					base3 = 1;
					base2 = 0;
					base1 = 0;
				}else {
					score += base3+base2+base1+1;
					base3 = 0;
					base2 = 0;
					base1 = 0;
				}
				curPlayer++;
				if(curPlayer == 9) curPlayer -= 9;
			}
			outCnt = 0;
		}
		return score;
	}
}
