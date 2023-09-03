package day0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
	
	public static class C implements Comparable<C>{
		int no;
		int T;
		int P;
		
		public C(int no, int t, int p) {
			this.no = no;
			this.T = t;
			this.P = p;
		}

		@Override
		public int compareTo(C o) {
			return o.P - this.P;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		C input[] = new C[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			input[i] = new C( i,
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		PriorityQueue<C> pq = new PriorityQueue<C>(); 
		Queue<C> queue = new LinkedList<C>();
		Stack<int[]> result = new Stack<int[]>();
		for (int i = 0; i < N; i++) {
			pq.add(new C(input[i].no, input[i].T, input[i].P));
			
			int size = pq.size();
			for (int j = 0; j < size; j++) {
				C c = pq.poll();
				
				if(--c.T == 0) {
					int stackSize = result.size();
					for (int k = stackSize-1; k >= 0; k--) {
						int[] r = result.get(k);
						if(r[2] <= c.P && r[0] > c.no && r[0] <= c.no + input[c.no].T) {
							result.pop();
							result.add(new int[] {c.no, input[c.no].T, c.P});
						}else if (c.no > r[0]+r[1]){
							result.add(new int[] {c.no, input[c.no].T, c.P});
						}else {
							break;
						}
					}
					
					if(stackSize == 0) {
						result.add(new int[] {c.no, input[i].T, input[i].P});						
					}
				}else {		
					queue.add(new C(c.no, c.T, c.P));
				}
			}
			
			pq.addAll(queue);
			queue.clear();
		}
		
		int sum = 0;
		for (int i = 0; i < result.size(); i++) {
			sum += result.get(i)[2];
		}
		System.out.println(sum);
		
	}
}
