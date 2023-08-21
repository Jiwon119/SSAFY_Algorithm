package day0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	
	public static int data[][], N, Min, list[];
	public static boolean visited[];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		for (int T = 1; T <= testCase ; T++) {
			N = Integer.parseInt(br.readLine());
			data = new int [N+2][2];
			list = new int[N];
			visited = new boolean[N+2];
			Min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N+2; i++) {
				data[i][0] = Integer.parseInt(st.nextToken());
				data[i][1] = Integer.parseInt(st.nextToken());
			}
			permutation(0);
			sb.append('#').append(T).append(' ').append(Min).append('\n');
		}
		System.out.println(sb);

	}
	
	public static void permutation(int depth) {
		if(depth == N) {
//			System.out.println(Arrays.toString(list));
			int temp = getDistance();
			if(temp < Min) Min = temp;
			return;
		}
		
		// 회사와 집을 제외하고 순열
		for (int i = 2; i < data.length; i++) {
			if(visited[i]) continue;
			
			list[depth] = i;
			visited[i] = true;
			permutation(depth+1); 
			visited[i] = false;
		}
	}
	public static int getDistance() {
		int sum = 0;
		
		// 회사의 거리
		int x = data[0][0];
		int y = data[0][1];
		
		for (int i = 0; i < N; i++) {
			sum += Math.abs(x-data[list[i]][0]) + Math.abs(y-data[list[i]][1]);
			x = data[list[i]][0];
			y = data[list[i]][1];
		}
		sum += Math.abs(x-data[1][0]) + Math.abs(y-data[1][1]);
		
		return sum;
	}
}
