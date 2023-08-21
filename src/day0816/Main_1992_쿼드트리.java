package day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		int[][] data = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				data[i][j] = str.charAt(j) - '0';
			}
		}
		
		
		
		
		
		
		
	}
}
