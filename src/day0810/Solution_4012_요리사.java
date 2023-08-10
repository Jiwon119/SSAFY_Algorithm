package day0810;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	
	public static int N, data[][], result;
	public static boolean combList[];
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream(new File("src/day0810/4012_input.txt")));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk;
		
		int testcase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= testcase; T++) {
			N = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			data = new int[N][N];
			combList = new boolean[N];
			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					data[i][j] = Integer.parseInt(tk.nextToken());
				}
			}
			comb(0,0);
			
			sb.append("#").append(T).append(' ').append(result).append('\n');
		}
		System.out.println(sb);

	}
	public static void comb(int start, int depth) {
		if(depth == N/2) {
			getSum();
			return;
		}
		
		for (int i = start; i < N; i++) {
			combList[i] = true;
			comb(i+1, depth+1);
			combList[i] = false;
		}
	}
	
	public static void getSum() {
		int Asum=0, Bsum=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(combList[i] && combList[j]) {
					Asum += data[i][j];
				}else if(!combList[i] && !combList[j]) {
					Bsum += data[i][j];
				}
			}	
		}
		result = Math.min(Math.abs(Asum-Bsum), result);
	}
	
}