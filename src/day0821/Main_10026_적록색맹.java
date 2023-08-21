package day0821;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색맹 {
	
	public static int N, result1, result2;
	
	public static int X[] = {0,0,1,-1};
	public static int Y[] = {1,-1,0,0};
	
	public static char data[][];
	public static boolean visited[][];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		data = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			data[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bfs();
			}
		}
		bfs();
		visited = new boolean[N][N];
		bfs2();
		System.out.println(result1 + " "+result2);
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if(visited[x][y]) continue;
				
				queue.add(new int[] {x,y});
				visited[x][y] = true;
				result1++;
				
				while(!queue.isEmpty()) {
					int[] temp = queue.poll();
					
					for (int i = 0; i < 4; i++) {
						int dx = temp[0] + X[i];
						int dy = temp[1] + Y[i];
						
						if(check(dx, dy) && data[temp[0]][temp[1]] == data[dx][dy]) {
							visited[dx][dy] = true;
							queue.add(new int[] {dx, dy});
						}
					}
				}
				
			}
		}
	}
	
	public static void bfs2() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if(visited[x][y]) continue;
				
				queue.add(new int[] {x,y});
				visited[x][y] = true;
				result2++;
				
				while(!queue.isEmpty()) {
					int[] temp = queue.poll();
					
					for (int i = 0; i < 4; i++) {
						int dx = temp[0] + X[i];
						int dy = temp[1] + Y[i];
						
						if(check(dx, dy) && 
								(data[temp[0]][temp[1]] == data[dx][dy] ||
								 (data[temp[0]][temp[1]] == 'R' && data[dx][dy] == 'G') ||
								 (data[temp[0]][temp[1]] == 'G' && data[dx][dy] == 'R'))) {
							visited[dx][dy] = true;
							queue.add(new int[] {dx, dy});
						}
					}
				}
				
			}
		}
	}
	
	
	
	public static boolean check(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N || visited[x][y]) {
			return false;
		}
		return true;
	}
	
	
}
