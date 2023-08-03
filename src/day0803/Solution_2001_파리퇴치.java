package day0803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src//day0803//2001_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		int n, m;
		int[][] sum;
		int max, temp;
		for (int T = 1; T <= testCase; T++) {
			tk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tk.nextToken());
			m = Integer.parseInt(tk.nextToken());
			sum = new int[n][n+1];

			for (int i = 0; i < n; i++) {
				tk = new StringTokenizer(br.readLine());
				temp = 0;
				for (int j = 1; j <= n; j++) {
					sum[i][j] = temp + Integer.parseInt(tk.nextToken());
					temp = sum[i][j];
				}
			}

			max = Integer.MIN_VALUE;
			temp = 0;
			for (int i = 0; i < n-m+1; i++) {
				for (int j = 0; j < n-m+1; j++) {
					for (int i2 = 0; i2 < m; i2++) {
						temp += (sum[i+i2][j+m] - sum[i+i2][j]);
					}
					if(temp > max) {
						max = temp;
					}
					temp = 0;
				}
			}
			sb.append('#').append(T).append(' ').append(max).append('\n');
		}
		System.out.println(sb);
	}
}
		