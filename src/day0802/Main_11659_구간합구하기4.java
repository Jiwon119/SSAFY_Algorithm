package day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 	N과 M의 범위 -> 100,000 
 	누적합
	arr[0] / arr[1] / arr[2] / arr[3] / arr[4]   / arr[5]
   	  0        5       5+4     5+4+3    5+4+3+2    5+4+3+2+1
 */

public class Main_11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		token = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		
		int[] sum = new int[n+1];
		
		token = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(token.nextToken());
		}
		
		int start, end;
		for (int i = 0; i < m; i++) {
			token = new StringTokenizer(br.readLine());
			start = Integer.parseInt(token.nextToken());
			end = Integer.parseInt(token.nextToken());
			
			
			System.out.println(sum[end] - sum[start-1]);
		}
	}
}
