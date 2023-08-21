package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	
	public static int R, C, result, map[][];
	public static boolean[] visited;
	public static int[] X = {0,0,1,-1};
	public static int[] Y = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}
		
		visited[map[0][0]] = true;
		dfs(0,0,0);
		System.out.println(result+1);
	}
	public static void dfs(int x, int y, int idx) {
		int dx, dy;
		
		if(result < idx) {
			result = idx;
		}
		
		for (int i = 0; i < 4; i++) {
			dx = x + X[i];
			dy = y + Y[i];
			
			if( dx<0 || dx>=R || dy<0 || dy>=C ) continue;
			if( visited[map[dx][dy]] ) continue;
			
			visited[map[dx][dy]] = true;
			dfs(dx, dy, idx+1);
			visited[map[dx][dy]] = false;
		}
	}
}
