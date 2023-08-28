package day0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {
	
	public static class Tunnel implements Comparable<Tunnel>{
		int a;
		long len;
		
		public Tunnel(int a, long len) {
			super();
			this.a = a;
			this.len = len;
		}

		@Override
		public int compareTo(Tunnel o) {
			return Long.compare(this.len, o.len);
		}
	}
	
	public static int N, X[], Y[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= TestCase; T++) {
			N = Integer.parseInt(br.readLine());

			X = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			
			Y = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			List<Tunnel>[] tList = new LinkedList[N];
			for (int i = 0; i < tList.length; i++) {
				tList[i] = new LinkedList<Tunnel>();
			}
			
			PriorityQueue<Tunnel> pq = new PriorityQueue<Tunnel>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					long x = Math.abs(X[i]-X[j]);
					long y = Math.abs(Y[i]-Y[j]);
					tList[i].add(new Tunnel(j, x*x + y*y));
					tList[j].add(new Tunnel(i, x*x + y*y));
				}
			}
			
			int cnt = 0;
			long result = 0;
			boolean[] visited = new boolean[N];
			
			pq.add(new Tunnel(0, 0));
			
			while(!pq.isEmpty()) {
				Tunnel tunnel = pq.poll();
				
				if(visited[tunnel.a]) continue;
				
				visited[tunnel.a] = true;
				result += tunnel.len;
				cnt++;
				
				if(cnt == N) {
					break;
				}
				
				for (int i = 0; i < tList[tunnel.a].size(); i++) {
					if(visited[tList[tunnel.a].get(i).a]) continue;
					
					pq.add(tList[tunnel.a].get(i));
				}
			}
			sb.append('#').append(T).append(' ').append(Math.round(result * E)).append('\n');
		}
		System.out.println(sb);
	}
}