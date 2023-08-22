package day0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	
	public static int N, M, map[][], tempMap[][], selList[], zeroCnt, Max;
	public static LinkedList<int[]> cctvList = new LinkedList<int[]>();
	//상 우 하 좌
	public static int[][] dir= {{-1,0}, {0,1}, {1,0}, {0,-1}};
	
	public static int[][][] cctvType= {
		{},
		{{0},{1},{2},{3}},	
		{{0,2}, {1,3}},
		{{0,1}, {1,2}, {2,3}, {3,0}},
		{{0,1,2}, {1,2,3}, {2,3,0}, {3,0,1}},
		{{0,1,2,3}}
	};
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		Max = Integer.MIN_VALUE;
		
		map = new int[N][M];
		tempMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) {
					cctvList.add(new int[] {map[i][j], i, j});
				}
				if(map[i][j] == 0) {
					zeroCnt++;
				}
			}
		}
		
		selList = new int[cctvList.size()];
		selectDir(0);
		System.out.println(zeroCnt-Max);
	}
	
	public static void selectDir(int depth) {
		if(depth == cctvList.size()) {
			copy();
			Max = Math.max(Max, get());
			return;
		}
		
		int cctv = cctvList.get(depth)[0];
		for (int i = 0; i < cctvType[cctv].length; i++) {
			selList[depth] = i;
			selectDir(depth+1);
		}
		
	}
	public static int get() {
		int cnt = 0;
		
		for (int i = 0; i < selList.length; i++) {
			int[] cctvInfo = cctvList.get(i);
			int cctvStatus = selList[i];
			
			int[] curCCTV = cctvType[cctvInfo[0]][cctvStatus];
			
			for (int j : curCCTV) {
				int dx = cctvInfo[1];
				int dy = cctvInfo[2];
				while(true) {
					dx += dir[j][0];
					dy += dir[j][1];
					
					if(check(dx, dy)) {
						if(tempMap[dx][dy] == 0) {
							tempMap[dx][dy] = -1;
							cnt++;
						}
					}else {
						break;
					}
				}
			}
		}
		return cnt;
	}
	
	public static boolean check(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=M || tempMap[x][y] == 6) {
			return false;
		}
		return true;
	}

	public static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
	}
	
}
