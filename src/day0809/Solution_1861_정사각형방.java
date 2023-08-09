package day0809;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {
	
	/**
	 * 문제
	 * 처음 어떤 수가 적힌 방에서 있어야 가장 많은 개수의 방을 이동할 수 있는지 구하는 프로그램
	 * 이동하려는 방에 적힌 숫자 = 현재 방에 적힌 숫자 + 1
	 * 상하좌우 이동 가능
	 * */
	
	// bfs 이용
	// 배열의 각 자리에서 bfs를 돌려 몇개의 방을 이동할 수 있는지 구하고 max 값을 갱신
	
	public static Queue<int[]> queue = new ArrayDeque<>();
	public static int[][] path = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	public static int N, cnt;
	public static int[][] data;
	
	
	public static void bfs(int x, int y) {
		cnt = 1;
		queue.offer(new int[] {x,y});
		
		while(!queue.isEmpty()) {	// 탐색 대상이 없을때까지 반복
			int[] temp = queue.poll();
			
 			for (int i = 0; i < 4; i++) {	// 상하좌우 값 중 이동할 수 있는 방 큐에 넣음
				int dx = temp[0] + path[i][0];
				int dy = temp[1] + path[i][1];
				
				if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
					continue;
				}

				if(data[temp[0]][temp[1]]+1 ==  data[dx][dy]) {
					queue.offer(new int[] {dx, dy});
					cnt++;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream(new File("src\\day0809\\1861_input.txt")));
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			data = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(br.readLine());				
				for (int j = 0; j < N; j++) {
					data[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			
			int roomNum = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i,j);
					if(cnt > max) {
						roomNum = data[i][j];
						max = cnt;
					}else if(cnt == max) {
						roomNum = Math.min(roomNum, data[i][j]);
					}
					
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(roomNum).append(" ").append(max).append("\n");
			
		}
		System.out.println(sb);
		
	}
}
