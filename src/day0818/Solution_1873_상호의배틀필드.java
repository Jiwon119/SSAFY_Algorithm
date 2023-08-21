package day0818;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {

	// U D L R
	private static int[] dirX = {-1,1,0,0};
	private static int[] dirY = {0,0,-1,1};
	
	private static int H, W, x, y, cur;
	private static char[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("src/day0817/1873_input.txt")));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		for (int T = 1; T <= testCase; T++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				map[i] = str.toCharArray();
			}
			
			Loop : for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] == '^') {
						cur = 0;
						map[i][j] = '.';
						x = i; y = j;
						break Loop;
					}
					else if(map[i][j] == 'v') {
						cur = 1;
						map[i][j] = '.';
						x = i; y = j;
						break Loop;
					}
					else if(map[i][j] == '<') {
						cur = 2;
						map[i][j] = '.';
						x = i; y = j;
						break Loop;
					}
					else if(map[i][j] == '>') {
						cur = 3;
						map[i][j] = '.';
						x = i; y = j;
						break Loop;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			char[] input= br.readLine().toCharArray();
			
			for (char c : input) {
				if(c == 'U') {
					check(x-1, y);
					cur = 0;
				}else if(c == 'D') {
					check(x+1, y);
					cur = 1;
				}else if(c == 'L') {
					check(x, y-1);
					cur = 2;
				}else if(c == 'R') {
					check(x, y+1);
					cur = 3;
				}else if(c == 'S') {
					shoot();
				}
			}
			
			// U D L R
			if(cur == 0) {
				map[x][y] = '^';
			}else if(cur == 1) {
				map[x][y] = 'v';
			}else if(cur == 2) {
				map[x][y] = '<';
			}else if(cur == 3) {
				map[x][y] = '>';
			}
			
			sb.append('#').append(T).append(' ');
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
	
	public static void check(int dx, int dy) {
		if(dx < 0 || dx >= H || dy < 0 || dy >= W) {
			return;
		}
		if( map[dx][dy] == '.') {
			x = dx; y = dy;
		}
	}
	public static void shoot() {
		int dx = x + dirX[cur];
		int dy = y + dirY[cur];
		while(dx >= 0 && dx < H && dy >= 0 && dy < W) {
			if(map[dx][dy] == '*') {
				map[dx][dy] = '.';
				break;
			}else if(map[dx][dy] == '#') {
				break;
			}
			dx += dirX[cur];
			dy += dirY[cur];
		}
	}
}
