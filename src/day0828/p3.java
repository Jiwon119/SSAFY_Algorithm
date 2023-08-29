package day0828;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p3 {

	// H 짝수 && W 짝수 || H 홀수 && W 짝수
	// 상하좌우 + 오른쪽 위 + 왼쪽 위
	public static int X1[] = {-1,1,0,0,-1,-1};
	public static int Y1[] = {0,0,-1,1,1,-1};
	
	// H 짝수 && W 홀수 || H 홀수 && W 홀수
	// 상하좌우 + 오른쪽 아래 + 왼쪽 아래
	public static int X2[] = {-1,1,0,0,1,1};
	public static int Y2[] = {0,0,-1,1,1,-1};
	
	public static long result;
	public static int W, H, cell[][], select[];
	public static boolean visited[][];

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream(new File("src/a/p2_input.txt")));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		StringBuilder sb = new StringBuilder();
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= TestCase; T++) {
			result = 0;
			
			tk = new StringTokenizer(br.readLine());
			W = Integer.parseInt(tk.nextToken());
			H = Integer.parseInt(tk.nextToken());
			
			cell = new int[H][W];
			for (int i = 0; i < H; i++) {
				tk = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					cell[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			
			select = new int[4];
			visited = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					dfs(0,i,j);
				}
			}
			
			
			sb.append('#').append(T).append(' ').append(result*result).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void dfs(int depth, int x, int y) {
		
		select[depth] = cell[x][y];
		visited[x][y] = true;
		
		if(depth == 3) {
			int sum = 0;
			System.out.println(Arrays.toString(select));
			for (int i = 0; i < 4; i++) {
				sum += select[i];
			}
			result = Math.max(result, sum);
			
			return;
		}
		
		int dx, dy;
		// H 짝수 && W 짝수 || H 홀수 && W 짝수
		if( (x%2==0 && y%2==0) || (x%2==1 && y%2==0)) {
			for (int i = 0; i < 6; i++) {
				dx = x + X1[i];
				dy = y + Y1[i];
				if(check(dx, dy)) {
					dfs(depth+1, dx, dy);
					visited[dx][dy] = false;
				}
			}
		}else {
			for (int i = 0; i < 6; i++) {
				dx = x + X2[i];
				dy = y + Y2[i];
				if(check(dx, dy)) {
					dfs(depth+1, dx, dy);	
					visited[dx][dy] = false;
				}
			}
		}
		
		
		
	}
	public static boolean check(int x, int y) {
		if(x<0 || x>=H || y<0 || y>=W || visited[x][y]) {
			return false;
		}
		return true;
	}
	
	
}
