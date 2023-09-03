package day0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
	
	public static int N, M, memo[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int T = 0; T < TestCase; T++) {
			
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			memo = new int[N+1][M+1];
			
			
			sb.append(dp(N,M)).append('\n');
		}
		System.out.println(sb);
	}
	
	public static int dp(int i, int j) {
		if(j == i) {
			return 1;
		} else if(j == 1) {
			return i;
		} else if(memo[i][j] == 0){
			memo[i][j] = dp(i-1, j-1) + dp(i-1, j);
		}
		return memo[i][j];
	}
}
