package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	
	public static int parents[], N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		StringBuilder sb = new StringBuilder();
		
		int TestCase = Integer.parseInt(br.readLine());
		for (int T = 1; T <= TestCase; T++) {
			sb.append('#').append(T).append(' ');
			
			tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			M = Integer.parseInt(tk.nextToken());
			
			make();
			for (int i = 0; i < M; i++) {
				tk = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(tk.nextToken());
				int a = Integer.parseInt(tk.nextToken());
				int b = Integer.parseInt(tk.nextToken());
				
				if(t == 0) {
					union(a, b);				
				}else {
					if(find(a) == find(b)) sb.append(1);
					else sb.append(0);
				}
			}
			
		}
		System.out.println(sb);
	}
	
	
	public static void make() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;	// 자기 자신을 부모로 하는 단위 집합
		}
	}
	
	public static int find(int n) {
		if(parents[n] == n) return n;
		return find(parents[n]);
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
	}
}
