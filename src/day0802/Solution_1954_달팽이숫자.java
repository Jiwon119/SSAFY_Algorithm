package day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1954_달팽이숫자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[][] path = {{0,1}, {1,0}, {0,-1},{-1,0}};
		
		
		int n, x, y;
		for (int i = 1; i <= T; i++) {
			n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			int cnt = 1;
			int pathIdx = 0;
			x = 0; y = -1;
			while(cnt <= n*n) {
				int dx = x + path[pathIdx][0];
				int dy = y + path[pathIdx][1];
				if(dx >= n || dx < 0 || dy >= n || dy < 0 || arr[dx][dy] != 0) {
					pathIdx += 1;
					if(pathIdx > 3) pathIdx -= 4;
					dx = x + path[pathIdx][0];
					dy = y + path[pathIdx][1];
				}
				x = dx; y = dy;
				arr[x][y] = cnt++;
			}
			sb.append('#').append(i).append('\n');
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					sb.append(arr[j][j2]).append(' ');
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
}
