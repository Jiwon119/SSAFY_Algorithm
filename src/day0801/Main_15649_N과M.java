package day0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_N과M {
	static boolean[] visit;
	static int[] arr;
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int depth) {
		if(depth == m) {
			for (int i : arr) {
				sb.append(i+1).append(" ");
//				System.out.print(i+1 + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				arr[depth] = i;
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(token.nextToken());
		m = Integer.parseInt(token.nextToken());
		
		visit = new boolean[n];
		arr = new int[m];
		
		dfs(0);
		System.out.println(sb);
	}
}
