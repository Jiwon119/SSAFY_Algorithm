package day0829;

import java.util.Arrays;
import java.util.Scanner;

public class DP_2_막대연결하기 {
	
	public static int memo[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		memo = new int[N+2];
		Arrays.fill(memo, -1);
		memo[1] = 2;
		memo[2] = 5;
		
		System.out.println(dp(N));
	}
	public static int dp(int n) {
		if(n>2 && memo[n] == -1) {
			memo[n] = dp(n-1)*2 + dp(n-2);
		}
		
		return memo[n];
	}
	
}
