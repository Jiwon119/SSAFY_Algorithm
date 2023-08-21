package day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 놓아진 퀸의 열번호를 기록하는 버전
public class NQueenTest2 {
	
	private static int N, ans;
	private static boolean[] rowCheck, diaCheck1, diaCheck2;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		rowCheck = new boolean[N+1];
		
		// row + col -> 오른쪽 아래(\) 대각선. 대각선은 합이 같음
		// 대각선의 수는 2*N-1개 생성. 1번 인덱스 사용 X
		diaCheck1 = new boolean[2*N];
		
		// row - col -> 왼쪽 아래(/) 대각선. 대각선은 차가 같음
		diaCheck2 = new boolean[2*N];
		
		ans = 0;	// 가능한 경우의 수
		
		setQueen(1);
		System.out.println(ans);
	}
	
	public static void setQueen(int row) {
		if(row > N) {
			ans++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(rowCheck[i] || diaCheck1[row+i-1] || diaCheck2[row-i+N]) continue;
			rowCheck[i] = diaCheck1[row+i-1] = diaCheck2[row-i+N] = true;
			setQueen(row+1);
			rowCheck[i] = diaCheck1[row+i-1] = diaCheck2[row-i+N] = false;
		}
	}
}
