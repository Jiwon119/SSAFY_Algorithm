package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {
	
	public static int N, M;
	public static List<Integer>[] graph;
	public static boolean visited[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		
		graph = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i,1);
			visited[i] = false;
		}
		
		System.out.println(0);
	}

	private static void dfs(int num, int depth) {
		if(depth == 5) {
			System.out.println(1);
			System.exit(0);
		}
		for (int i = 0; i < graph[num].size(); i++) {
			if(visited[graph[num].get(i)]) continue;
				
			visited[num] = true;
			dfs(graph[num].get(i), depth+1);
			visited[num] = false;
			
		}
	}
}
