package day0828;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4 {

	// H 짝수 && W 짝수 || H 홀수 && W 짝수
	// 상하좌우 + 오른쪽 위 + 왼쪽 위
	public static int X1[] = {-1,1,0,0,-1,-1};
	public static int Y1[] = {0,0,-1,1,1,-1};
	
	// H 짝수 && W 홀수 || H 홀수 && W 홀수
	// 상하좌우 + 오른쪽 아래 + 왼쪽 아래
	public static int X2[] = {-1,1,0,0,1,1};
	public static int Y2[] = {0,0,-1,1,1,-1};
	
	public static long result;
	public static int W, H, cell[][], select[], selX[], selY[];
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
			selX = new int[4];
			selY = new int[4];
			comb(0,0);

			sb.append('#').append(T).append(' ').append(result*result).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void comb(int depth, int start) {
		if(depth == 4) {
			int minX = Integer.MAX_VALUE;
			int minY = Integer.MAX_VALUE;
			int maxX = Integer.MIN_VALUE;
			int maxY = Integer.MIN_VALUE;
			int dx, dy;

			for (int i : select) {
				dx = i / W;
				dy = i % W;
				if(dx < minX) minX = dx;
				if(dy < minY) minY = dy;
				if(dx > maxX) maxX = dx;
				if(dy > maxY) maxY = dy;
			}
			
			if(maxX-minX >= 4) return;
			if(maxY-minY >= 4) return;
			
			visited = new boolean[H][W];
			if(check(visited)) {
				int sum = 0;
				for (int i = 0; i < 4; i++) {
					dx = select[i] / W;
					dy = select[i] % W;
					sum += cell[dx][dy];
				}
				result = Math.max(result, sum);
			}
			return;
		}
		
		for (int i = start; i < H*W; i++) {
			
			selX[depth] = i / W;

			Arrays.sort(selX);

			
			if(selX[depth]-selX[0] > 4) continue;

			
			
			select[depth] = i;
			comb(depth+1, i+1);
			
		}	
	}
	
	public static boolean check(boolean[][] visited) {
		Queue<Integer> queue = new LinkedList<>();
		
		int x = select[0] / W;
		int y = select[0] % W;
		queue.add(select[0]);
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			x = num / W;
			y = num % W;
			
			int dx, dy;
			if( (x%2==0 && y%2==0) || (x%2==1 && y%2==0)) {
				for (int i = 0; i < 6; i++) {
					dx = x + X1[i];
					dy = y + Y1[i];
					
					if(Rangecheck(dx, dy)) {
						int temp = dx*W + dy;
						for (int j = 0; j < select.length; j++) {
							if(select[j] == temp) {
								queue.add(temp);
								visited[dx][dy] = true;
							}
						}
					}
				}
			}else {
				for (int i = 0; i < 6; i++) {
					dx = x + X2[i];
					dy = y + Y2[i];
					
					if(Rangecheck(dx, dy)) {
						int temp = dx*W + dy;
						for (int j = 0; j < select.length; j++) {
							if(select[j] == temp) {
								queue.add(temp);
								visited[dx][dy] = true;
							}
						}
					}
				}
			}
		}

		for (int i : select) {
			int rx = i / W;
			int ry = i % W;
			if(!visited[rx][ry]) return false;
		}
		
		return true;
	}
	
	public static boolean Rangecheck(int x, int y) {
		if(x<0 || x>=H || y<0 || y>=W || visited[x][y]) {
			return false;
		}
		return true;
	}
	
	
}
