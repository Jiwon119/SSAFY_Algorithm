package day0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1463_1로만들기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		

		System.out.println(BottomUp(N));
		System.out.println(bfs(N));
	}
	
	public static int BottomUp(int N) {
		int dp[] = new int[N+1];
		dp[1] = 0;
		
		for (int i = 2; i < N+1; i++) {
			dp[i] = dp[i-1] + 1;	// 1을 뺴는 연산
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		
		return dp[N];
	}
	
	public static int bfs(int N) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[] visited = new boolean[N+1];
		queue.add(new int[] {1,0});
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			if(visited[tmp[0]]) continue;
			
			visited[tmp[0]] = true;
			
			if(tmp[0] == N) {
				return tmp[1];
			}
			
			queue.add(new int[] {tmp[0]+1, tmp[1]+1});
			if(tmp[0]*2 <= N) {
				queue.add(new int[] {tmp[0]*2, tmp[1]+1});
			}
			if(tmp[0]*3 <= N) {
				queue.add(new int[] {tmp[0]*3, tmp[1]+1});				
			}
		}
		
		return 0;
	}
}
