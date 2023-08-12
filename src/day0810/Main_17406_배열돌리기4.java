package day0810;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	
	public static int[] X = {1, 0, -1, 0};
	public static int[] Y = {0, 1, 0, -1};
	public static int N, M, K, Min, originArr[][], tempArr[][], resultArr[][], rotationOrder[][], rotationInfo[][];
	public static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("src/day0810/17406_input.txt")));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk;

		tk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		K = Integer.parseInt(tk.nextToken());
		Min = Integer.MAX_VALUE;
		
		originArr = new int[N+1][M+1];
		tempArr = new int[N+1][M+1];
		resultArr = new int[N+1][M+1];
		
		for (int i = 1; i <= N; i++) {			
			tk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				originArr[i][j] = Integer.parseInt(tk.nextToken());
				resultArr[i][j] = originArr[i][j];
			}
		}
		
		rotationInfo = new int[K][3];
		rotationOrder = new int[K][3];
		for (int i = 0; i < K; i++) {
			tk = new StringTokenizer(br.readLine());
			rotationInfo[i] = new int[] {Integer.parseInt(tk.nextToken()),
										 Integer.parseInt(tk.nextToken()),
										 Integer.parseInt(tk.nextToken())};
		}
		
		visited = new boolean[K];
		permutation(0);
		System.out.println(Min);

	}
	
	// 순열
	private static void permutation(int depth) {
		if(depth == K) {
			for (int i = 0; i < K; i++) {
				int r = rotationOrder[i][0];
				int c = rotationOrder[i][1];
				int s = rotationOrder[i][2];
				
				arrRotation(new int[] {r-s, c-s}, new int[] {r+s, c+s}, resultArr);
			}
			getMin(resultArr);
			
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= M; j++) {
					resultArr[i][j] = originArr[i][j];
				}
			}
			tempArr = new int[N+1][M+1];
			
			return;
		}
		for (int i = 0; i < K; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			rotationOrder[depth] = rotationInfo[i];
			
			permutation(depth+1);
			visited[i] = false;
			
			
		}
		
	}
	
	private static void getMin(int[][] getMinArr) {
		// 각 배열의 최소값 구하는 연산
		
		for (int i = 1; i <= N; i++) {
			int temp = 0;
			for (int j = 0; j <= M; j++) {
				temp += getMinArr[i][j];
			}
			Min = Math.min(temp, Min);
		}
	}
	

	private static void arrRotation(int[] start, int[] end, int[][] resultArr) {
		int startX = start[0];
		int startY = start[1]; 
		int w = end[0] - start[0];
		int h = end[1] - start[1];
		
		int typeIdx = 0, cnt=0;
		while(true) {
			if(typeIdx == 3 && startX == start[0] && startY == start[1]) {
				cnt++;
				start[0]++; start[1]++; end[0]--; end[1]--;
				startX = start[0];
				startY = start[1];
				typeIdx = 0;
				if(cnt == (Math.min(w, h)/2)) break;
			};
			int dx = startX + X[typeIdx];
			int dy = startY + Y[typeIdx];
			
			if(dx < start[0] || dx > end[0] || dy < start[1] || dy > end[1]) {
				typeIdx++;
				dx = startX + X[typeIdx];
				dy = startY + Y[typeIdx];
			}
			
			tempArr[startX][startY] = resultArr[dx][dy];
			startX = dx; startY = dy;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(tempArr[i][j] != 0) {
					resultArr[i][j] = tempArr[i][j];
				}
			}
		}
		
	}
}
