package day0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거2 {
	
	public static int[][][] tunnel = {
			{},									// 0번 인덱스 사용 X
			{{0,1}, {0,-1}, {1,0}, {-1,0}},		// 1번 터널
			{{1,0}, {-1,0}},                	// 2번 터널
			{{0,1}, {0,-1}},               		// 3번 터널
			{{1,0,0,1}, {0,-1,-1,0}},        	// 4번 터널
			{{-1,0,0,1}, {0,-1,-1,0}},        	// 5번 터널
			{{-1,0,0,-1}, {0,1,1,0}},        	// 6번 터널
			{{1,0,0,-1}, {0,1,-1,0}}        	// 7번 터널
	};
	public static int[][] visited;
	public static int N, M, result, map[][];
	public static Queue<int[]> queue = new LinkedList<int[]>();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk;
		
		int test_case = Integer.parseInt(br.readLine());
		for (int T = 0; T < test_case; T++) {
			result = 0;
			tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());    // 세로 크기
			M = Integer.parseInt(tk.nextToken());    // 가로 크기
			int R = Integer.parseInt(tk.nextToken());    // 맨홀 뚜껑이 위치한 장소의 세로 위치
			int C = Integer.parseInt(tk.nextToken());    // 맨홀 뚜껑이 위치한 장소의 가로 위치
			int L = Integer.parseInt(tk.nextToken());
			
			map = new int[N][M];
			visited = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			
			bfs(R, C);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited[i][j] <= L && visited[i][j] != 0) {
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}
	
	private static void bfs(int x, int y) {
		queue.add(new int[] {x, y});
		visited[x][y] = 1;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int tunnelNum = map[temp[0]][temp[1]];
			
			for (int i = 0; i < tunnel[tunnelNum].length; i++) {
				
				int dx, dy, nextDirX, nextDirY;
				if(tunnelNum == 1 || tunnelNum == 2 || tunnelNum == 3) {
					dx = temp[0] + tunnel[tunnelNum][i][0];
					dy = temp[1] + tunnel[tunnelNum][i][1];
					nextDirX = tunnel[tunnelNum][i][0];
					nextDirY = tunnel[tunnelNum][i][1];
				}else {
					dx = temp[0] + tunnel[tunnelNum][i][2];
					dy = temp[1] + tunnel[tunnelNum][i][3];
					nextDirX = tunnel[tunnelNum][i][2];
					nextDirY = tunnel[tunnelNum][i][3];
				}
				
				
				if(check(dx, dy, tunnelNum, nextDirX, nextDirY)) {
					queue.add(new int[] {dx, dy});
					visited[dx][dy] = visited[temp[0]][temp[1]]+1;
				}
			}
		}
	}
	private static boolean check(int x, int y, int tunnelNum, int dirX, int dirY) {
		if( x<0 || x>=N || y<0 || y>=M ) return false;
		if( map[x][y] == 0 ) return false;
		if( visited[x][y] != 0 ) return false;
		
		int nextTNum = map[x][y];
		for (int i = 0; i < tunnel[nextTNum].length; i++) {
			if(nextTNum == 1 || nextTNum == 2 || nextTNum == 3) {
				if( dirX == tunnel[nextTNum][i][0]
						&& dirY == tunnel[nextTNum][i][1])
					return true;                
			}else {
				if( (dirX == tunnel[nextTNum][i][0] 
						&& dirY == tunnel[nextTNum][i][1]))
					return true;
			}
		}
		
		return false;
	}
}
