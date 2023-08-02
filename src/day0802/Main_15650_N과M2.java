package day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_N과M2 {
	
	static int N, M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void comb(int start, int index) {
		if(index == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = start; i <= N; i++) {
			result[index] = i;
			comb(i, index+1);
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(token.nextToken());	// N까지의 자연수
		M = Integer.parseInt(token.nextToken());	// 길이 M
		result = new int[M];
		
		comb(1, 0);
		System.out.println(sb);
	}
}
