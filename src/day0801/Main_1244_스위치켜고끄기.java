package day0801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		
		int switchNum = Integer.parseInt(br.readLine());
		//0번 인덱스는 사용 X
		int[] switchArr = new int[switchNum+1];
		
		token = new StringTokenizer(br.readLine());
		for (int i = 1; i <= switchNum; i++) {
			switchArr[i] = Integer.parseInt(token.nextToken());
		}
		
		int stdNum = Integer.parseInt(br.readLine());
		int[][] stdArr = new int[stdNum][2];
		for (int i = 0; i < stdNum; i++) {
			token = new StringTokenizer(br.readLine());
			stdArr[i][0] = Integer.parseInt(token.nextToken());
			stdArr[i][1] = Integer.parseInt(token.nextToken());
		}
		
		for (int i = 0; i < stdNum; i++) {
			if(stdArr[i][0] == 1) {
				//남학생인 경우
				int index = stdArr[i][1];
				while(index <= switchNum) {
					switchArr[index] = switchArr[index] == 0? 1: 0;
					index += stdArr[i][1];
				}
			} else {
				//여학생인 경우
				int cnt = 1;
				
				// 학생이 받은 스위치 번호
				switchArr[stdArr[i][1]] = switchArr[stdArr[i][1]] == 0? 1: 0;
				
				while(cnt < switchNum) {
					int right = stdArr[i][1] + cnt;
					int left = stdArr[i][1] - cnt;
					
					if(right > switchNum || left <= 0) break;
					
					if(switchArr[right] == switchArr[left]) {
						switchArr[right] = switchArr[right] == 0? 1: 0;
						switchArr[left] = switchArr[left] == 0? 1: 0;
					}else {
						break;
					}
					cnt++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= switchNum; i++) {
			sb.append(switchArr[i]);
			if(i % 20 == 0) sb.append('\n');
			else sb.append(' ');
		}
		
		System.out.println(sb);
	}
}
