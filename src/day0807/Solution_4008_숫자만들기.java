package day0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_4008_숫자만들기 {
	
	
	private static int operCnt;

	public static void dfs(int depth, int idx) {
		

		
	}

	public static void main(String[] args) throws Exception {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token;

		int testCase = Integer.parseInt(br.readLine());
		int n, plus, minus, product, division;
		int[] data;
		
		for (int T = 1; T <= testCase; T++) {
			n = Integer.parseInt(br.readLine());
			token = new StringTokenizer(br.readLine());
			
			plus = Integer.parseInt(token.nextToken());
			minus = Integer.parseInt(token.nextToken());
			product = Integer.parseInt(token.nextToken());
			division = Integer.parseInt(token.nextToken());
			
			operCnt = plus + minus + product + division;
			
			data = new int[operCnt+1];
			
			
			
			
			sb.append('#').append(T).append(' ').append(11).append('\n');
		}
		System.out.println(sb);
		
	}
}
