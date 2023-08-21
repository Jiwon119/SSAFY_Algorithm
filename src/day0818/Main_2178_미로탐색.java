package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	
	public static int N, M, map[][];
	public static boolean visited[][];
	
	// 상 하 좌 우
	public static int X[] = {-1,1,0,0};
    public static int Y[] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j-1)-'0';
			}
		}
		
		bfs();
		System.out.println(map[N][M]);
		
	}
	public static void bfs() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {1,1});
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int dx = temp[0] + X[i];
				int dy = temp[1] + Y[i];
				
				if(dx < 1 || dx >N || dy < 1 || dy >M) {
					continue;
				}
				
				if(map[dx][dy] == 1) {
					map[dx][dy] = map[temp[0]][temp[1]]+1;
					
					queue.add(new int[] {dx, dy});
				}	
			}
		}
	}
}
