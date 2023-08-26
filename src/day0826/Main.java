package day0826;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * 첫째 줄에 격자판의 크기 R, C와 상어의 수 M
	 * 둘째 줄부터 M개의 줄에 상어의 정보가 주어진다. 
	 * 상어의 정보는 다섯 정수 r, c, s, d, z (1 ≤ r ≤ R, 1 ≤ c ≤ C, 0 ≤ s ≤ 1000, 1 ≤ d ≤ 4, 1 ≤ z ≤ 10000) 
	 * 로 이루어져 있다. (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다. 
	 * d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.
	 */
	
	static class Shark {
		int r; // 상어 x좌표
		int c; // 상어 y좌표
		int s; // 속력
		int d; // 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽
		int z; // 크기
		
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
		
	}
	
	static int R, C, M; // R, C : 격자판 크기, M : 상어 마리 수
	static int[][] board; // 격자판
	static int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, 1, -1}; // {의미X, 북, 남, 동, 서}
	static Map<Integer, Shark> sharkInfo; // 상어 정보 배열
	
	static StringTokenizer st;
	
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[R+2][C+2];
		
		sharkInfo = new HashMap<>();
		int sharkNum = 1;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			sharkInfo.put(sharkNum, new Shark(r, c, s, d, z));
			
			board[r][c] = sharkNum++;
		}
		
		for (int i = 1; i < C+1; i++) {
			for (int j = 1; j < R+1; j++) {
				
				if (board[j][i] > 0) { // 상어가 있다면 포획 하기
					int sharkN = board[j][i]; // 상어 번호
					board[j][i] = 0; // 상어 격자판에서 제외
					
					answer += sharkInfo.get(sharkN).z; // 상어 크기 더해주기
					sharkInfo.remove(sharkN); // 상어 정보 없애기
					break;
				}
			}
			// 상어 이동
			board = sharkMove();
		}
		
		System.out.println(answer);
	}
	
	private static int[][] sharkMove() {
		
		int[][] tmpBoard = new int[R+2][C+2]; // 상어 동시 이동을 처리하기 위한 임시 격자판
		for (int i = 1; i < R+1; i++) {
			for (int j = 1; j < C+1; j++) {
				
				if (board[i][j] > 0) { // 상어가 있다면 이동 시켜주기
					
					int sharkN = board[i][j]; // 상어 번호
					
					Shark shark = sharkInfo.get(sharkN); // 상어 정보 불러오기
					
					int sharkSpeed = shark.s; // 상어 속력
					int mx = shark.r; // 상어 x좌표
					int my = shark.c; // 상어 y좌표
					int dir = shark.d; // 상어 이동 방향
					int z = shark.z; // 상어 크기
					for (int k = 0; k < sharkSpeed; k++) { // 상어 속력만큼 이동
						
						int tmpX = mx + dx[dir];
						int tmpY = my + dy[dir];

						if (!isRange(tmpX, tmpY)) { // 격자판 끝에 다다르면 방향 전환
							if (dir == 1) dir = 2;
							else if (dir == 2) dir = 1;
							else if (dir == 3) dir = 4;
							else if (dir == 4) dir = 3;
							
							tmpX = mx + dx[dir];
							tmpY = my + dy[dir];
						}
						
						mx = tmpX;
						my = tmpY;						
					}
					
					if (tmpBoard[mx][my] > 0) { // 도착한 곳에 또 다른 상어가 있다면 싸우기 (크기 순)
						
						int enemySharkN = tmpBoard[mx][my]; // 자리차지 하고 있는 상어 번호
						
						// 이동하고 있는 상어가 크기가 더 크면 잡아 먹고 자리 차지 후, 잡아먹힌 상어는 상어 정보(sharkInfo)에서 제외
						if (sharkInfo.get(sharkN).z > sharkInfo.get(enemySharkN).z) {
							tmpBoard[mx][my] = sharkN;
							sharkInfo.put(sharkN, new Shark(mx, my, sharkSpeed, dir, z));
							sharkInfo.remove(enemySharkN);
						}
						else { // 원래 자리 차지 하고 있는 상어가 더 크면 자리 정보 입력 후 이동하려는 상어는 상어 정보(sharkInfo)에서 제외
							sharkInfo.remove(sharkN);
						}
					}
					
					else if (tmpBoard[mx][my] == 0) { // 또 다른 상어가 없다면 이동하고 있는 상어가 자리 차지
						tmpBoard[mx][my] = sharkN;

						sharkInfo.put(sharkN, new Shark(mx, my, sharkSpeed, dir, z));
					}

				}
			}
		}
		
		return tmpBoard;
	}

	private static boolean isRange(int mx, int my) {
		
		return (1 <= mx && mx <= R && 1 <= my && my <= C);
	}

}

