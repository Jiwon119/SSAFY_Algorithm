package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	private static int r, c, cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tk.nextToken());
		int NN = (int) Math.pow(2, N);
		r = Integer.parseInt(tk.nextToken()); 
		c = Integer.parseInt(tk.nextToken());
		
		search(0, 0, NN);
	}
	private static void search(int x, int y, int size) {
		
		if(size == 1) {
			System.out.println(cnt);
			return;
		}
		
		int half = size/2;
		
		if( r < x+half && c < y+half) {
			search(x, y, half);
		}
		
		else if( r < x+half && c < y+half*2 ) {
			cnt += (size*size) / 4;
			search(x, y+half, half);
		}
		
		else if( r < x+half*2 && c < y+half ) {
			cnt += (size*size) / 4 *2;
			search(x+half, y, half);
		}
		
		else if( r < x+half*2 && c < y+half*2 ) {
			cnt += (size*size)/4 *3;
			search(x+half, y+half, half);
		}
	}
}


/**
 * 처음 풀었던 방식 -> 시간초과
 * 조건을 주지 않고 분할정복을 이용하여 모든 경우의 수에 재귀를 돌렸더니 시간초과가 남
 * 찾으려는 값의 좌표 위치에 따라 재귀를 선택적으로 돌려서 시간초과 문제를 해결
package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {
	private static int r, c, cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tk.nextToken());
		int NN = (int) Math.pow(2, N);
		r = Integer.parseInt(tk.nextToken()); 
		c = Integer.parseInt(tk.nextToken());

		cnt = -1;
		search(0, 0, NN);
	}
	private static void search(int x, int y, int size) {
		
		if(size == 1) {
			cnt++;
			if(x == r && y == c) {
				System.out.println(cnt);
			}
			return;
		}else {
			int half = size/2;
			search(x, y, half);
			search(x, y+half, half);
			search(x+half, y, half);
			search(x+half, y+half, half);
		}
	}
}
 * 
 */

