package day0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567_색종이2 {
		public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[][] map = new int[102][102];
		int result = 0;
		int num = Integer.parseInt(br.readLine());	// 색종이 수 
		for (int n = 0; n < num; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++) {					
					map[i][j] = 1;
				}
			}
		}
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if(map[i][j] == 1) {
					if(map[i-1][j] == 0) result++;
					if(map[i+1][j] == 0) result++;
					if(map[i][j-1] == 0) result++;
					if(map[i][j+1] == 0) result++;
				}
			}
		}
		System.out.println(result);
	}
}
