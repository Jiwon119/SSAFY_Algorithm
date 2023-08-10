package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {
	
	public static int N, M, arr[][], tempArr[][];;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk;
		
		
		tk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		int R = Integer.parseInt(tk.nextToken());
		
		arr = new int[N][M];
		tempArr = new int[N][M];
		
		for (int i = 0; i < N; i++) {			
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		
		tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int type = Integer.parseInt(tk.nextToken());
			switch (type) {
			case 1:
				func1();
				break;
			case 2:
				func2();
				break;
			case 3:
				func3();
				break;
			case 4:
				func4();
				break;
			case 5:
				func5();
				break;
			case 6:
				func6();
				break;
			default:
				break;
			}
			arr = tempArr;
			tempArr = new int[N][M];
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	// 상하 반전
	private static void func1() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempArr[i][j] = arr[N-i-1][j];
			}
		}
	}

	// 좌우 반전
	private static void func2() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempArr[i][j] = arr[i][M-j-1];
			}
		}
	}
	
	// 오른쪽으로 90도
	private static void func3() {
		tempArr = new int[M][N];
		int temp = M;
		M = N;
		N = temp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempArr[i][j] = arr[M-j-1][i];
			}
		}
	}

	// 왼쪽으로 90도
	private static void func4() {
		tempArr = new int[M][N];
		int temp = M;
		M = N;
		N = temp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempArr[i][j] = arr[j][N-i-1];
			}
		}
		
	}

	// 4그룹 나눠 시계방향 회전
	private static void func5() {
		//1번 부분
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tempArr[i][j] = arr[N/2+i][j];
			}
		}
		
		// 2번 부분
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tempArr[i][M/2+j] = arr[i][j];
			}
		}
		
		// 3번 부분
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tempArr[N/2+i][M/2+j] = arr[i][M/2+j];
			}
		}
		// 4번 부분
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tempArr[N/2+i][j] = arr[N/2+i][M/2+j];
			}
		}
	}
	
	// 4그룹 나눠 반시계방향 회전
	private static void func6() {
		//1번 부분
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tempArr[i][j] = arr[i][M/2+j];
			}
		}
		
		// 2번 부분
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tempArr[i][M/2+j] = arr[N/2+i][M/2+j];
			}
		}
		
		// 3번 부분
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tempArr[N/2+i][M/2+j] = arr[N/2+i][j];
			}
		}
		// 4번 부분
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				tempArr[N/2+i][j] = arr[i][j];
			}
		}
	}

}
