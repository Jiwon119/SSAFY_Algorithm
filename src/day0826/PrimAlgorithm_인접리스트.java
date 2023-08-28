package day0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//프림 알고리즘 이용 : PriorityQueue 버전
/*
1
3 3
1 2 1
2 3 2
1 3 3

3
*/

public class PrimAlgorithm_인접리스트 {
	
	public static class Edge implements Comparable<Edge>{
		int v;
		int cost;
		
		public Edge(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= TestCase; T++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[V+1];
			
			List<Edge>[] EdgeList = new LinkedList[V+1];
			for (int i = 0; i <= V; i++) {
				EdgeList[i] = new LinkedList<Edge>();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				EdgeList[from].add(new Edge(to, weight));
				EdgeList[to].add(new Edge(from, weight));
			}
			
			long result = 0;
			int cnt = 0;
			
			PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
			pq.add(new Edge(1, 0));
			
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				
				if(visited[edge.v]) continue;
				
				result += edge.cost;	// 가중치 더함
				visited[edge.v] = true;	// 방문처
				cnt++;	// 방문한 노드 수 증가
				
				if(cnt == V) {
					break;
				}
				
				for (Edge e : EdgeList[edge.v]) {
					if(!visited[e.v]) {
						pq.add(e);
					}
				}
			}
			sb.append('#').append(T).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
}
