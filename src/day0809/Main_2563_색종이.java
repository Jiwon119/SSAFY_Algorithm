package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		int n = Integer.parseInt(br.readLine());	// 색종이 수
		int[][] data = new int[100][100];
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(br.readLine());
			
			int w = Integer.parseInt(tk.nextToken());
			int h = Integer.parseInt(tk.nextToken());
			
			
			for (int x = w; x < w+10; x++) {
				for (int y = h; y < h+10; y++) {
					if(data[x][y] == 0) {
						data[x][y] = 1;
						result++;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
