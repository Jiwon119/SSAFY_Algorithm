package day0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기 {
	
	// 방향 배열 선언
	private static int[][] path = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	private static Deque<Integer> deque = new LinkedList<Integer>();
	private static int[][] data;
	private static int n, m, r;
	
	
	public static void main(String[] args) throws Exception{
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(tk.nextToken());	// row
		m = Integer.parseInt(tk.nextToken());	// column
		r = Integer.parseInt(tk.nextToken());	// 회전 수
		
		// 데이터 입력 받음
		data = new int[n][m];
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				data[i][j] = Integer.parseInt(tk.nextToken());
			}
		}

		for (int i = 0; i < Math.min(n, m)/2; i++) {
			getDeque(i);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(data[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}
	
	public static void getDeque(int cnt) {
		// 시작 x, y 값 / 몇번째 사각형인지 -> 끝 값을 알기 위한 용도
		int pathIdx = 0;
		int x = cnt;
		int y = cnt;
		int dx, dy;
		while(pathIdx < 4) {
			deque.add(data[x][y]);
			
			dx = x + path[pathIdx][0];
			dy = y + path[pathIdx][1];
			
			if(dx < cnt || dx >= n-cnt || dy < cnt || dy >= m-cnt) {
				pathIdx++;
				dx = x + path[pathIdx][0];
				dy = y + path[pathIdx][1];
			}
			if(pathIdx == 3 && dx == cnt && dy == cnt) {
				break;
			}
			x = dx; y = dy;
		}
		rotation();
		setDeque(cnt);
	}
	
	public static void setDeque(int cnt) {
		// 시작 x, y 값 / 몇번째 사각형인지 -> 끝 값을 알기 위한 용도
		int pathIdx = 0;
		int x = cnt;
		int y = cnt;
		int dx, dy;
		
		int dequeIdx = 0;
		while(pathIdx < 4) {
			data[x][y] = deque.pollFirst();
			
			dx = x + path[pathIdx][0];
			dy = y + path[pathIdx][1];
			
			if(dx < cnt || dx >= n-cnt || dy < cnt || dy >= m-cnt) {
				pathIdx++;
				dx = x + path[pathIdx][0];
				dy = y + path[pathIdx][1];
			}
			if(pathIdx == 3 && dx == cnt && dy == cnt) {
				break;
			}
			x = dx; y = dy;
		}
	}
	
	
	public static void rotation() {
		for (int i = 0; i < r; i++) {
			int temp = deque.pollLast();
			deque.addFirst(temp);
		}
	}
	
}
