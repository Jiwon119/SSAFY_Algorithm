package day0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 요약
 * R*C 의 맵에서 가스관과 빵집을 연결하는 파이프라인의 최대 개수를 구하는 프로그램
 * 첫번째 열 : 가스관 / 마지막 열 : 빵집
 * 파이프는 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결할 수 있다.
 * 
 * 문제 풀이 
 * 1. DFS로 시작부분부터 탐색한다.
 * 	  모든 파이프는 한 줄로 연결되기 때문에 DFS를 사용해야 한다 
 *   -> 오른쪽 위, 오른쪽, 오른쪽 아래로 탐색하다가 파이프를 만난다면 다시 돌아와서 추가 탐색을 해야 하는데
 *   BFS 같은 경우는 모든 지점에서 추가 탐색을 그만둬야 하기 때문에 깊이 우선 탐색인 DFS 사용
 *   
 * 2. 끝까지 갔는데 최종 y좌표가 C-1과 같다면, 
 *    파이프라인이 설치된 것 => 다른 탐색 필요없음, 파이프라인 생성 여부 저장
 *    
 * 3. 파이프 연결을 실패했을 경우
 *    파이프 해제 X -> DFS를 통해 파이프를 연결하던 와중에 만약 더 이상 설치가 불가능 하다면
 *    해당 위치는 더이상 연결될 수 있는 가망이 없기 때문에 파이프를 해제하지 않고 
 *    다음 DFS에서 해당 위치를 탐색 하지 못하도록 함
 */


public class Main_3109_빵집 {
	
	static int R, C, answer;
	static char[][] board;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i] = str.toCharArray();
			}
		}
		
		for (int i = 0; i < R; i++) {
			if(backtracking(i, 0)) answer += 1;
		}
		
		System.out.println(answer);
	}
	
	private static boolean backtracking(int row, int col) {
		
		board[row][col] = 'O';	// 파이프 체크
		
		if (col == C-1) return true; // 빵집 도착
		
		// 대각선 오른쪽 위
		if (row - 1 >= 0 && board[row-1][col+1] == '.') { // 이동할 수 있는 경우
			if (backtracking(row-1, col+1)) {
				return true; 
			}        
		}
		
		// 오른쪽
		if (board[row][col+1] == '.') { 
			if (backtracking(row, col+1)) {
				return true;
			}
		}
		
		// 대각선 오른쪽 아래
		if (row + 1 < R && board[row+1][col+1] == '.') {
			if (backtracking(row+1, col+1)) {
				return true; 
			}
		}
		
		return false;
	}
	
}
