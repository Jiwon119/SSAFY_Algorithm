package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	
	
	private static int data[][], white, blue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		int N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		func(0,0,N);
		System.out.println(white);
		System.out.println(blue);

	}
	public static void func(int x, int y, int size) {
		int sum = 0;
		
		if(size == 1) {
			if(data[x][y] == 0) white++;
			else blue++;
			return;
		}
		
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				sum += data[i][j];
			}
		}
		
		if(sum == 0) {
			white++;
		}else if(sum == size*size) {
			blue++;
		}else {
			int half = size/2;
			func(x, y, half);
			func(x+half, y, half);
			func(x, y+half, half);
			func(x+half, y+half, half);
		}
	}
}
