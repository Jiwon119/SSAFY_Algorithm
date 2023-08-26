package day0821;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질2 {
	private static int N, K;
	private static boolean visited[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tk.nextToken());
		K = Integer.parseInt(tk.nextToken());
		visited = new boolean[100001];
		
		bfs();
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {N, 0});
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			if(temp[0] == K) {
				System.out.println(temp[1]);
				return;
			}
			
			if(temp[0]+1 <= 100000 && !visited[temp[0]+1]) {
				visited[temp[0]+1] = true;
				queue.add(new int[] {temp[0]+1, temp[1]+1});				
			}
			
			if(temp[0]-1 >= 0 && !visited[temp[0]-1]) {
				visited[temp[0]-1] = true;
				queue.add(new int[] {temp[0]-1, temp[1]+1});				
			}
			
			if(temp[0]*2 <= 100000 && !visited[temp[0]*2]) {
				visited[temp[0]*2] = true;
				queue.add(new int[] {temp[0]*2, temp[1]+1});				
			}
		}
	}
}
