package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	
	public static int data[][], result[], turn[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;

		data = new int[4][8];
		result = new int[4];
		turn = new int[4];
		
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				data[i][j] = str.charAt(j)-'0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			turn = new int[4];
			tk = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(tk.nextToken()) -1;
			int dir = Integer.parseInt(tk.nextToken());
			
			turn[num] = dir;
			int left, right;
			
			int t = dir;				
			for (int j = num-1; j >= 0 ; j--) {
				t = 1*(-1);				
				
				left  = (result[j+1]+6) % 8; 
				right = (result[j]+2) % 8;
				
				if(data[j][right] != data[j+1][left]) {
					turn[j] = t;
				}else {
					
					break;
				}
			}
			
			t = dir;
			for (int j = num+1; j < 4; j++) {
				t = 1*(-1);	
				
				left  = (result[j-1]+2) % 8; 
				right = (result[j]+6) % 8;
				
				if(data[j-1][left] != data[j][right]) {
					turn[j] = t;
				}else {
					break;
				}
			}
			for (int j = 0; j < 4; j++) {
				if(turn[j] == 0) continue;
				
				setIdx(j, turn[j]);
			}
		}
		
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if(data[i][result[i]] == 1) {
				int temp = 1;
				for (int j = 0; j < i; j++) {
					temp *= 2;
				}
				sum += temp;
			}
		}
		System.out.println(sum);
	}
	
	public static void setIdx(int num, int dir) {

		if(dir == -1) {
			// 반시계방향으로 회전시 
			int idx = (result[num] + 1) % 8;
			result[num] = idx;
		}else {
			// 시계방향으로 회전시
			int idx = (result[num] - 1) < 0? 7 : result[num] - 1;
			result[num] = idx;
		}
	}
	
}
