package day0824;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {
	
	public static class V implements Comparable<V>{
		int no;
		long d;
		
		public V(int no, long d) {
			super();
			this.no = no;
			this.d = d;
		}

		@Override
		public int compareTo(V o) {
			return Long.compare(this.d, o.d);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("src/day0824/1251_input.txt")));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= TestCase; T++) {
			int N = Integer.parseInt(br.readLine());
			List<V>[] EdgeList = new ArrayList[N];
			
			long X[] = new long[N];
			long Y[] = new long[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}

			double E = Double.parseDouble(br.readLine());
					
			for (int i = 0; i < N; i++) {
				EdgeList[i] = new ArrayList<V>();
				for (int j = 0; j < N; j++) {
					if(i != j) {
						long x = Math.abs(X[i]-X[j]);
						long y = Math.abs(Y[i]-Y[j]);
						EdgeList[i].add(new V(j, x*x + y*y));
						
					}
				}
			}
			
			boolean[] visited = new boolean[N];
			long result = 0;
			int cnt = 0;
			PriorityQueue<V> pq = new PriorityQueue<>();
			pq.add(new V(0, 0));
			
			while(!pq.isEmpty()) {
				V v = pq.poll();
				
				if(visited[v.no]) continue;
				
				result += v.d;
				cnt++;
				visited[v.no] = true;
				
				if(cnt >= N) {
					
					break;
				}
				
				for (int i = 0; i < EdgeList[v.no].size(); i++) {
					if(!visited[EdgeList[v.no].get(i).no]) {
						pq.add(EdgeList[v.no].get(i));
					}
				}
				
			}
			
			
			sb.append('#').append(T).append(' ').append(Math.round(result * E)).append('\n');
			
		}
		System.out.println(sb);

	}
}
