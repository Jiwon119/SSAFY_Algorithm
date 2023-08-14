package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//------------미완성----------------
/**
 * N×M의 행렬로 표현되는 맵에서 최단거리를 구하는 프로그램
 * 0:이동 가능 / 1:이동 불가능
 * 이동중 벽 한개를 부수고 이동하는게 빠른경우 한개까지 부수고 이동할 수 있음
 * 이동가능 칸 : 상하좌우로 인접한 칸
 */

public class boj_2206_벽부수고이동하기 {
	
	public static int N, M, data[][], tempData[][], cnt, Min;
	public static boolean check[][];
	public static Queue<int[]> queue = new LinkedList<int[]>();
	public static LinkedList<int[]> roadList = new LinkedList<int[]>();
	public static int[] X = {0,0,1,-1};
	public static int[] Y = {1,-1,0,0};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		Min = Integer.MAX_VALUE;
		String str;
		
		data = new int[N][M];
		check = new boolean[N][M];
		
		// 벽 개수 세는 리스트
		tempData = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				data[i][j] = str.charAt(j)-'0';
				if(data[i][j] == 1) roadList.add(new int[] {i,j});
			}
		}
		
//		dataReset();
		bfs();

		
//		System.out.println(check? Min: -1);
	}
	
	public static void dataReset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempData[i][j] = data[i][j];
			}
		}
	}
	
	
	public static void bfs() {
		// 넘은 벽의 개수를 저장
		queue.add(new int[] {0,0});
		data[0][0] = 1;
		check[0][0] = true;
		
		if(data[N-1][M-1] != 0) {
			Min = data[N-1][M-1];
			return;
		}
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int dx = temp[0] + X[i];
				int dy = temp[1] + Y[i];
				
				if(dx<0 || dx>=N || dy<0 || dy>=M) {
					continue;
				}
				
				if(tempData[dx][dy] > 1) {
					continue;
				}
				
				if(check[dx][dy]) continue;
				
				if(dx == N-1 && dy == M-1) {
					data[dx][dy] = data[temp[0]][temp[1]]+1;
					break;
				}
				
				
				if(data[dx][dy] == 1) {
					data[dx][dy] = data[temp[0]][temp[1]]+1;
					tempData[dx][dy] = tempData[temp[0]][temp[1]]+1;
					queue.add(new int[] {dx, dy});						
				}else {
					data[dx][dy] = data[temp[0]][temp[1]]+1;
					tempData[dx][dy] = tempData[temp[0]][temp[1]];
					queue.add(new int[] {dx, dy});						
				}
				check[dx][dy] = true;
			}
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					System.out.print(data[j][j2] + "," + tempData[j][j2] + "\t");
				}
				System.out.println();
			}
			System.out.println();
			
		}
	}
}

//6 4
//0000
//1110
//1000
//0000
//0111
//0000
