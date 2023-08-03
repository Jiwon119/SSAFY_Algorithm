package day0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
	
	static int[][] data;
	static int N, M, Min;
	static boolean[] visited;
	static int[][] result;
	
	static void func(int start, int resultIdx) {
		if(resultIdx == M) {
			int[] r = {1,0};
			for (int i = 0; i < M; i++) {
				r[0] *= result[i][0];
				r[1] += result[i][1];
			}
			if(Math.abs(r[0]-r[1]) < Min) Min = Math.abs(r[0]-r[1]);
			return;
		}

		for (int i = start; i < N; i++) {
			result[resultIdx] = data[i];
			func(i+1, resultIdx+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		N = Integer.parseInt(br.readLine());
		data = new int[N][2];
		
		visited = new boolean[N];
		Min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			data[i][0] = Integer.parseInt(token.nextToken());
			data[i][1] = Integer.parseInt(token.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			result = new int[i][2];
			M = i;
			func(0,0);
		}
		System.out.println(Min);
	}
}