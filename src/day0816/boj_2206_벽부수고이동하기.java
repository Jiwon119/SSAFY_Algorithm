package day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2206_벽부수고이동하기 {
	
	public static int N, M, data[][], dis[][][];
	public static Queue<int[]> queue = new LinkedList<int[]>();
	public static int[] X = {0,0,1,-1};
	public static int[] Y = {1,-1,0,0};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		String str;
		
		data = new int[N][M];
		dis = new int[2][N][M];
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					dis[i][j][j2] = -1;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				data[i][j] = str.charAt(j)-'0';
			}
		}
		bfs();
		System.out.println(-1);
	}
	
	public static void bfs() {
		queue.add(new int[] {0,0,1});
		dis[1][0][0] = 1;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int px = temp[0];
			int py = temp[1];
			int floor = temp[2];
			
			if(px == N-1 && py == M-1) {
				System.out.println(dis[floor][px][py]);
				System.exit(0);
			}
			
			for (int i = 0; i < 4; i++) {
				int dx = px + X[i];
				int dy = py + Y[i];
				
				if(dx<0 || dx>=N || dy<0 || dy>=M) {
					continue;
				}
				
				
				if(data[dx][dy] == 0) {
					if(dis[floor][dx][dy] == -1) {
						dis[floor][dx][dy] = dis[floor][px][py]+1;
						queue.add(new int[] {dx, dy, floor});					
					}

				}
				else if(data[dx][dy] == 1){
					if(floor > 0 && dis[floor-1][dx][dy] == -1) {
						dis[floor-1][dx][dy] = dis[floor][px][py]+1;
						queue.add(new int[] {dx, dy, floor-1});
					}
				}
			}
		}
	}
}