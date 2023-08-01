package day0801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1 {
	static int y;
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src\\day0801\\Ladder_input.txt"));
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;

		
		for (int test = 0; test < 10; test++) {
			boolean[][] visit = new boolean[100][100];
			int[][] arr = new int[100][100];
			int test_case = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				token = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(token.nextToken());
					if(arr[i][j] == 2) {
						y = j;
					}
				}
			}
		
		
			int x = 99;
			
			while (x > 0) {
				if(y+1 < 100 && arr[x][y+1] == 1 && !visit[x][y+1]) {
					visit[x][y] = true;
					y += 1;
				}else if(y-1 >= 0 && arr[x][y-1] == 1 && !visit[x][y-1]) {
					visit[x][y] = true;
					y -= 1;
				}else {
					visit[x][y] = true;
					x -= 1;
				}
				System.out.println(y);

			}
			sb.append("#").append(test_case).append(" ").append(y).append("\n");
		}
		System.out.println(sb);
		
	}
}
