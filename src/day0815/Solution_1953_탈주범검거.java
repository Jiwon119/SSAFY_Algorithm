package day0815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {

	// 방향 배열 (왼←, 위↑, 오→, 아↓ 순)
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] dir = { // 2차원 방향 배열 (0 : 왼쪽, 1 : 위쪽, 2 : 오른쪽, 3 : 아래)
	    {}, 
	    {0, 1, 2, 3}, 
	    {1, 3}, 
	    {0, 2}, 
	    {1, 2}, 
	    {2, 3}, 
	    {3, 0}, 
	    {0, 1}
	};

	static boolean[][] open = { // 이동하려는 길이 열려있는지 확인하는 2차원 배열 - (왼←, 위↑, 오→, 아↓ 순)
	        {},
	        {true, true, true, true},
	        {false, true, false, true},
	        {true, false, true, false},
	        {false, true, true, false},
	        {false, false, true, true},
	        {true, false, false, true},
	        {true, true, false, false}
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
			N = Integer.parseInt(tk.nextToken());	// 세로 크기
			M = Integer.parseInt(tk.nextToken());	// 가로 크기
			int R = Integer.parseInt(tk.nextToken());	// 맨홀 뚜껑이 위치한 장소의 세로 위치
			int C = Integer.parseInt(tk.nextToken());	// 맨홀 뚜껑이 위치한 장소의 가로 위치
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
//					System.out.print(visited[i][j] + "\t");
					if(visited[i][j] <= L && visited[i][j] != 0) {
						result++;
					}
				}
//				System.out.println();
			}
			System.out.println("#" + (T+1) + " " + result);
		}	
	}

	private static void bfs(int r, int c) {
		queue.add(new int[] {r, c});
		visited[r][c] = 1;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			int tunnelNum = map[temp[0]][temp[1]];

			for (int i : dir[tunnelNum]) {
				int x, y;
				x = temp[0] + dx[i];
				y = temp[1] + dy[i];
				
				if(check(x, y, i)) {
					queue.add(new int[] {x, y});
					visited[x][y] = visited[temp[0]][temp[1]]+1;
				}
			}
		}
	}

	private static boolean check(int x, int y, int dir) {
		if( x<0 || x>=N || y<0 || y>=M ) return false;
		if( map[x][y] == 0 ) return false;
		if( visited[x][y] != 0 ) return false;
		
		//왼 위 오 아래
		int nextTNum = map[x][y];
		if(dir == 0) dir = 2;
		else if(dir == 1) dir = 3;
		else if(dir == 2) dir = 0;
		else if(dir == 3) dir = 1;
		dir = (dir+2) % 4;
		if(open[nextTNum][dir]) return true;
		
		return false;
	}
}