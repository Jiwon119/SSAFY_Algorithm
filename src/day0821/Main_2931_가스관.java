package day0821;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2931_가스관 {
	// 상 우 하 좌
	public static boolean open[][] = {	// 이동할 수 있는 통로 표시
		{true, false, true, false},		// | 블록	 - 0번 블록
		{false, true, false, true},		// - 블록 - 1번 블록
		{true, true, true, true},		// + 블록 - 2번 블록
		{false, true, true, false},		// 1 블록 - 3번 블록
		{true, true, false, false},		// 2 블록 - 4번 블록
		{true, false, false, true},		// 3 블록 - 5번 블록
		{false, false, true, true},		// 4 블록 - 6번 블록
	};
	
	public static int[] X = {-1,0,1,0};
	public static int[] Y = {0,1,0,-1};
	
	public static int R, C, Mx, My, Zx, Zy, T;
	public static char map[][];
	public static boolean[][] visited;
	public static LinkedList<int[]> list = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;

		tk = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tk.nextToken());	// 도면의 크기(행)
		C = Integer.parseInt(tk.nextToken());	// 도면의 크기(열)
		map = new char[R][C];	// 도면 정보를 저장할 map
		visited = new boolean[R][C];	// 방문처리를 위한 배열
		
		for (int i = 0; i < R; i++) {	// map 데이터 입력 받음
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'M') {
					Mx = i; My = j;	// 집 위치 입력
				} else if(map[i][j] == 'Z') {
					Zx = i; Zy = j;	// 유치원 위치 입력
				} else if(map[i][j] == '.') {
					list.add(new int[] {i, j});	// 비어있는 블록 리스트 추가
				} else {
					map[i][j] = getBlockNum(map[i][j]);	// 블록은 번호로 관리
					
				}
			}
		}
		
		setMap();

		
		System.out.println(sb);
	}
	
	public static void setMap() {	// 비어있는 블록에 7가지 블록데이터 입력하는 함수
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < 7; j++) {
				
				// 인접 블록이 있는 경우에만 블록을 추가하도록 코드 추가해야함.
				//
				visited = new boolean[R][C];
				map[list.get(i)[0]][list.get(i)[1]] = (j+"").charAt(0);
				if(bfs()) {
					String s = "";
					if(j == 0) s = "|";
					else if(j == 1) s = "-";
					else if(j == 2) s = "+";
					else if(j == 3) s = "1";
					else if(j == 4) s = "2";
					else if(j == 5) s = "3";
					else if(j == 6) s = "4";
					
					sb.append(list.get(i)[0] + 1).append(' ').append(list.get(i)[1] + 1).append(' ').append(s).append('\n');
					return;
				}
				map[list.get(i)[0]][list.get(i)[1]] = '.';
			}
		}
	}
	
	public static boolean bfs() {	// 맵을 돌며 도착을 하는지 확인하는 함수
		Queue<int[]> queue = new LinkedList<>();
		
		// 시작 블록 찾기
		for (int i = 0; i < 4; i++) {
			int dx = Mx + X[i];
			int dy = My + Y[i];
			
			if(check(dx, dy)) {
				if(map[dx][dy] != '.') {
					queue.add(new int[] {dx, dy, getBlockNum(map[dx][dy])});
					break;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int dx = temp[0] + X[i];
				int dy = temp[1] + Y[i];
				
				if(!check(dx, dy)) continue;
				if(visited[temp[0]][temp[1]]) continue;
				if(!open[temp[2]-'0'][i]) continue;
				if(map[dx][dy] == 'Z') return true;
				
				visited[temp[0]][temp[1]] = true;
				queue.add(new int[] {dx, dy, getBlockNum(map[dx][dy])});
				
			}
		}
		return false;
	}
	
	public static boolean check(int x, int y) {	
		if( x<0 || x>=R || y<0 || y>=C || map[x][y] == '.') { // 범위 체크, 비어있는 블록인 경우 이동 못하도록 체크
			return false;
		}
		
		return true;
	}
	
	public static char getBlockNum(char c) {	// 블록을 인덱스
		char num = '0';
		if(c == '|') num = '0';
		else if(c == '-') num = '1';
		else if(c == '+') num = '2';
		else if(c == '1') num = '3';
		else if(c == '2') num = '4';
		else if(c == '3') num = '5';
		else if(c == '4') num = '6';
			
		return num;
	}
}
