package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	
	public static int N, M, V, map[][];
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
				
		visited = new boolean[N+1];
		map = new int[N+1][N+1];
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[from][to] = 1;
			map[to][from] = 1;
		}

		dfs(V);
		System.out.println();
		
		visited = new boolean[N+1];
		bfs();
	}
	
	
	public static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for (int i = 1; i <= N; i++) {
			if(!visited[i] && map[v][i] == 1)
				dfs(i);
		}

	}
	
	public static void bfs() {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(V);
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			System.out.print(num + " ");
			
			for (int i = 1; i <= N; i++) {
				if(visited[i]) continue;
				if(map[num][i] == 1) {
					queue.add(i);
					visited[i] = true;
				}

			}
		}
		System.out.println();
	}
	
}
