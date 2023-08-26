package day0823;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	
	public static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	
	public static int V, E, parents[];
	public static Edge[] edgeList;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream(new File("src/day0823/3124_input.txt")));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= TestCase; T++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edgeList = new Edge[E];
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edgeList[i] = new Edge(Integer.parseInt(st.nextToken()),
										Integer.parseInt(st.nextToken()),
										Integer.parseInt(st.nextToken()));
			}
			
			make();
			
			Arrays.sort(edgeList);
			long result = 0;
			int cnt = 0;
			for (Edge edge : edgeList) {
				if(cnt == V-1) break;
				
				if(union(edge.from, edge.to)) {
					cnt++;
					result += edge.weight;
				}
			}
			
			
			sb.append('#').append(T).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
		
	}
	
	public static void make() {
		parents = new int[V+1];
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
}
