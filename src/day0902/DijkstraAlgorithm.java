package day0902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraAlgorithm {
	
	static class Node implements Comparable<Node> {
		int v;
		int weight;
		
		public Node (int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	static int V, E;
	static int start;
	static List<Node>[] graph;
	static boolean[] visited;
	static int[] distance;
	final static int INF = Integer.MAX_VALUE;
	
	static StringTokenizer st;
	
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		for (int i = 0; i <= V; i++)
			graph[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, w));
		}
		
		visited = new boolean[V+1];
		distance = new int[V+1];
		
		Arrays.fill(distance, INF);
		distance[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			if (visited[now.v])
				continue;
			
			visited[now.v] = true;
			
			for (Node next : graph[now.v]) {
				if (distance[next.v] > distance[now.v] + next.weight) {
					
					distance[next.v] = distance[now.v] + next.weight;
					pq.add(new Node(next.v, distance[next.v]));
				}
			}
		}
		
		for (int i = 1; i < V+1; i++) {
			System.out.println(distance[i] == INF ? "INF" : distance[i]);
		}
	}
}

