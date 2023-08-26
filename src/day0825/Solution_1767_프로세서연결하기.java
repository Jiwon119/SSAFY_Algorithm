package day0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {
	
	public static int N, map[][], result, coreNum, r;
	public static LinkedList<int[]> coreList = new LinkedList<int[]>();
	
	public static int X[] = {0,0,1,-1};
	public static int Y[] = {1,-1,0,0};
	public static boolean check[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= TestCase; T++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new boolean[N][N];
			result = 0;
			coreNum = 0;
			r = Integer.MAX_VALUE;
			coreList.clear();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(i != 0 && j != 0 && i != N-1 && j != N-1) {
							coreList.add(new int[] {i, j});							
						}
						check[i][j] = true;
					}
				}
			}
			dfs(0,0);
			sb.append('#').append(T).append(' ').append(r).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void dfs(int depth, int core) {
		
		if(depth == coreList.size()) {
			if(coreNum < core) {
				r = result;
				coreNum = core;
			}else if(coreNum == core) {
				r = Math.min(r, result);
			}
			return;
		}
		
		if((coreList.size()-depth) + core < coreNum) return;
		
		int x = coreList.get(depth)[0];
		int y = coreList.get(depth)[1];
		
		// 4방향 검사 
		for (int j = 0; j < 4; j++) {
			if((coreList.size()-depth) + core < coreNum) continue;
			
			if(checkPossible(x, y, j)) {
				result += setLine(x, y, j, true);
				dfs(depth+1, core+1);
				result -= setLine(x, y, j, false);
			}else {
				dfs(depth+1, core);
			}
		}
	}
	
	public static boolean checkPossible(int x, int y, int dir) {
		while(true) {
			x += X[dir];
			y += Y[dir];
			
			if(x<0 || x>=N || y<0 || y>=N) return true;
			if(check[x][y]) return false;
		}
	}
	
	public static int setLine(int x, int y, int dir, boolean b) {
		int cnt = 0;
		while(true) {
			x += X[dir];
			y += Y[dir];
			
			if(x<0 || x>=N || y<0 || y>=N) {
				return cnt;
			}
			check[x][y] = b;
			cnt++;
		}
	}
}
