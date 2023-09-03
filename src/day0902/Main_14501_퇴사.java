package day0902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int time[] = new int[N];
		int money[] = new int[N];
		int dp[] = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N-1; i >= 0; i--) {
			if(i + time[i] > N) {
				dp[i] = dp[i+1];
			}else {
				dp[i] = Math.max(money[i] + dp[i+time[i]], dp[i+1]);
			}
		}
		System.out.println(dp[0]);
	}
}