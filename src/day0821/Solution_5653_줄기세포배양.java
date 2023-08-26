package day0821;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5653_줄기세포배양 {
	
	public static class Cell implements Comparable<Cell>{
		int x, y;	// x, y
		int k;		// 생명력
		int t;		// 지속 시간

		public Cell(int x, int y, int k, int t) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.t = t;
		}

		@Override
		public int compareTo(Cell o) {
			// TODO Auto-generated method stub
			return o.k - this.k;
		}
	}
	
	public static int result, N, M, K, map[][];
	public static int[] X = {-1,1,0,0};
	public static int[] Y = {0,0,-1,1};
	public static boolean visited[][];
	public static Queue<Cell> queue = new LinkedList<Cell>();
	public static PriorityQueue<Cell> Pqueue = new PriorityQueue<Cell>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		StringBuilder sb = new StringBuilder();
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= TestCase; T++) {
			tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			M = Integer.parseInt(tk.nextToken());
			K = Integer.parseInt(tk.nextToken());
			
			map = new int[700][700];
			visited = new boolean[700][700];
			
			for (int i = 300; i < N+300; i++) {
				tk = new StringTokenizer(br.readLine());
				for (int j = 300; j < M+300; j++) {
					map[i][j] = Integer.parseInt(tk.nextToken());
					if(map[i][j] != 0) {
						Pqueue.add(new Cell(i, j, map[i][j], map[i][j]*2));
					}
				}
			}
			
			
			
			sb.append('#').append(T).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void bfs() {
		
		for (int i = 0; i < K; i++) {
			while(!Pqueue.isEmpty()) {
				
				
				
				
			}
			
		}
	}
	
	
}
