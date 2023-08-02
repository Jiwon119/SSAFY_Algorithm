package day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660_구간합구하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		token = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(token.nextToken());
		int m = Integer.parseInt(token.nextToken());
		
		int[][] sum = new int[n][n+1];
		
		
		
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(token.nextToken());
				sum[i][j] = sum[i][j-1] + num;
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		int firstX, firstY, secondX, secondY;
		for (int i = 0; i < m; i++) {
			
			token = new StringTokenizer(br.readLine());
			
			firstX = Integer.parseInt(token.nextToken());
			firstY = Integer.parseInt(token.nextToken());
			secondX = Integer.parseInt(token.nextToken());
			secondY = Integer.parseInt(token.nextToken());
			int result = 0;
			int index = firstX-1;
			for (int j = 0; j <= secondX - firstX; j++) {
				result += (sum[index][secondY] - sum[index][firstY-1]);
				index++;
			}
			sb.append(result).append('\n');
			
		}
		System.out.println(sb);
	}
}	
