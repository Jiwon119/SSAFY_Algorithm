package day0814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//------------미완성----------------
public class Main_1074_Z {
	private static int r, c, result, data[][];

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tk.nextToken());
		int NN = (int) Math.pow(2, N);
		r = Integer.parseInt(tk.nextToken()); 
		c = Integer.parseInt(tk.nextToken());

		int cnt = 0;
		search(0, 0, NN);
		System.out.println(result);
	}
	private static int search(int x, int y, int size) {
		
		if(size > 2) {
			int half = size/2;
			search(x, y, half);
			search(x, y+half, half);
			search(x+half, y, half);
			search(x+half, y+half, half);
		}else if(size == 2 ) {
			for (int i = x; i < x+2; i++) {
				for (int j = y; j < y+2; j++) {
					if(i == r && j ==c) {
						return result;
					} else {
						result++;
					}
				}
			}
		}

		return -1;
	}
}