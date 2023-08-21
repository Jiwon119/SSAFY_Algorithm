package day0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	
	public static int[] dx = {0, 0, 1, 0,-1};
	public static int[] dy = {0,-1, 0, 1, 0};
	public static int BClist[][], map[][];	// x좌표, y좌표, 충전범위, 처리량
	public static int A, B;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		for (int T = 0; T < testCase; T++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			int[] Amove = new int[M];
			int[] Bmove = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				Amove[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				Bmove[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					BClist[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			
			
			
		}
		
		
		
		
	}
}
