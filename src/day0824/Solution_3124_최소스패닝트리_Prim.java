package day0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리_Prim {
	
	public static class Vertex implements Comparable<Vertex>{
		int no;
		int weight;
		
		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= TestCase; T++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			
			
			for (int i = 0; i < E; i++) {
				
				
				
				
				
			}
			
			
			PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
			
			
			
			
			
			
			
			
			sb.append('#').append(T).append(' ').append(result).append('\n');
		}

		System.out.println(sb);		
	}
}
