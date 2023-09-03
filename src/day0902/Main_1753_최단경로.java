package day0902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	
	public static class Node implements Comparable<Node>{
		int v;
		int w;
		
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());	// 정점의 개수
		int E = Integer.parseInt(st.nextToken()); 	// 간선의 개수
		
		int K = Integer.parseInt(br.readLine());	// 시작 정점 번호
		
		ArrayList<Node>[] graph = new ArrayList[V+1];
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, w));
		}
		
		int INF = Integer.MAX_VALUE;
		
		boolean visited[] = new boolean[V+1];
		int distance[] = new int[V+1];
		
		Arrays.fill(distance, INF);	// 최소 거리를 구하기 위하여 MAX값으로 초기화
		distance[K] = 0;	// 시작 정점 거리 0
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(K, 0));	// 시작 정점 K 
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(visited[node.v]) continue;
			
			visited[node.v] = true;
			
			for (Node next : graph[node.v]) {
				if(distance[next.v] > distance[node.v]+next.w) {
					distance[next.v] = distance[node.v] + next.w;
					pq.add(new Node(next.v, distance[next.v]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			sb.append(distance[i] == INF ? "INF" : distance[i]).append('\n');
		}
		System.out.println(sb);
	}
}
