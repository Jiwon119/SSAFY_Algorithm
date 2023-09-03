package day0831;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말되고픈원숭이 {
	
	public static Queue<int[]> queue = new LinkedList<int[]>();
	public static int K, N, M, map[][], data[][][];
	public static boolean flag;
	public static int X[] = {0,0,1,-1};
	public static int Y[] = {1,-1,0,0};
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		flag = false;
		map = new int[N][M];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		data = new int[K+1][N][M];
		for (int i = 0; i <= K; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(data[i][j], -1);
			}
		}
		

		data[K][0][0] = 0;
		queue.add(new int[] {K,0,0});
		bfs();
		
		data[K][0][0] = 0;
		queue.add(new int[] {K,0,0});
		bfs();
		
		if(!flag) System.out.println(-1);
	}
	
	public static void bfs() {

		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int floor = tmp[0];
			int x = tmp[1];
			int y = tmp[2];
			
			if(x == N-1 && y == M-1) {
				System.out.println(data[floor][x][y]);
				flag = true;
				
				System.out.println(floor);
				for (int j = 0; j < N; j++) {
					System.out.println(Arrays.toString(data[floor][j]));
				}
				System.out.println();
				
				if(floor != 0) {
					
					
					
					
				}
				return;
			}
			
			
			
			for (int i = 0; i < 4; i++) {
				int dx = x + X[i];
				int dy = y + Y[i];
				
				if(!check(dx, dy)) continue;
				
				// 길
				if(map[dx][dy] == 0) {
					if(data[floor][dx][dy] == -1) {
						data[floor][dx][dy] = data[floor][x][y] + 1;
						queue.add(new int[] {floor, dx, dy});
						

						
					}
				}else {
					for (int j = 0; j < 4; j++) {
						for (int j2 = 0; j2 < 2; j2++) {
							if(j2 == 0) {
								dx = x + X[j] + X[j] + Y[j];
								dy = y + Y[j] + Y[j] + X[j];
							}else {
								dx = x + X[j] + X[j] + Y[j]*(-1);
								dy = y + Y[j] + Y[j] + X[j]*(-1);
							}
							
							if(!check(dx, dy)) continue;
							if(map[dx][dy] != 1 && floor>0 && data[floor-1][dx][dy] == -1) {
								data[floor-1][dx][dy] = data[floor][x][y] + 1;
								queue.add(new int[] {floor-1, dx, dy});								
							}
						}
					}		
				}
			}
			
		}
		
	}
	
	public static boolean check(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M) return false;
		
		return true;
	}
}
