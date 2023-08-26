package day0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17147_낚시왕{
	
	public static class Shark{
		int no;
		int r;	// 행
		int c;	// 열
		int s;	// 속력
		int d;	// 이동방향
		int z;	// 크기
		int moveCnt;
		
		public Shark(int no, int r, int c, int s, int d, int z) {
			this.no = no;
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	public static int R, C, M, map[][], maxMove, result;
	public static Map<Integer, Shark> sList = new HashMap<Integer, Shark>();
	
	// 위 아래 오른쪽 왼쪽
	public static int X[] = {0,-1,1,0,0};
	public static int Y[] = {0,0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R+1][C+1];
		maxMove = 0;
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			sList.put(i, new Shark( i, r, c,s, d, z));
			map[r][c] = i;
		}
		
		for (int t = 1; t <= C; t++) {
			f(t);
			setMove();			
			move();
			map = new int[R+1][C+1];
			SetMap();
		}
		System.out.println(result);
	}
	
	public static void f(int r) {
		for (int i = 1; i <= R; i++) {
			if(map[i][r] != 0) {
				result += sList.get(map[i][r]).z;
				sList.remove(map[i][r]);
				map[i][r] = 0;
				return;
			}
		}
	}
	
	public static void setMove() {
		for (int key : sList.keySet()) {
			Shark s = sList.get(key);
			
			if(s.s == 0) continue;

			if(s.d == 1 || s.d == 2) {
				s.moveCnt = s.s % ((R-1)*2);
			}else {
				s.moveCnt = s.s % ((C-1)*2);
			}
			maxMove = Math.max(maxMove, s.moveCnt);
		}
	}
	
	public static void move() {
		for (int key : sList.keySet()) {
			Shark s = sList.get(key);
			
			if(s.s == 0) continue;

			int moveNum;
			if(s.d == 1 || s.d == 2) {
				moveNum = s.s % ((R-1)*2);
			}else {
				moveNum = s.s % ((C-1)*2);
			}
			
			while(moveNum > 0) {
				
				int dx = s.r + X[s.d];
				int dy = s.c + Y[s.d];
				
				if(dx < 1 || dx > R || dy < 1 || dy > C) {
					if(s.d == 1) s.d=2;
					else if(s.d == 2) s.d=1;
					else if(s.d == 3) s.d=4;
					else if(s.d == 4) s.d=3;

					dx = s.r + X[s.d];
					dy = s.c + Y[s.d];
				}
				
				s.r = dx;
				s.c = dy;
				
				moveNum--;
			}
		}
	}
	
	public static void SetMap() {
		LinkedList<Integer> remove = new LinkedList<>();
		
		for (int key : sList.keySet()) {
			Shark s = sList.get(key);
			
			if(map[s.r][s.c] != 0) {
				if(sList.get(key).z < sList.get(map[s.r][s.c]).z) {
					remove.add(key);
					continue;
				}else {
					remove.add(map[s.r][s.c]);
				}
			}
			
			map[s.r][s.c] = s.no;
		}
		for (int i = 0; i < remove.size(); i++) {
			sList.remove(remove.get(i));
		}
	}
}
