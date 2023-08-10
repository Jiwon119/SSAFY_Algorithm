package day0810;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {
	
	static int result, N, L, data[][], list[][];
	
	// 부분집합
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("src\\day0810\\5215_input.txt")));
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk;
		
		int testcase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= testcase; T++) {
			tk = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(tk.nextToken());
			L = Integer.parseInt(tk.nextToken());
			
			data = new int [N][2];
			
			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(br.readLine());
				data[i][0] = Integer.parseInt(tk.nextToken());
				data[i][1] = Integer.parseInt(tk.nextToken());
			}
			
			result = 0;
			for (int i = 1; i <= N; i++) {
				list = new int[i][2];
				comb(0, 0, i);
			}
			sb.append('#').append(T).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
	
	
	public static void comb(int start, int depth, int num) {
		if(depth == num) {
			int sumScore = 0, sumCal=0;
			for (int i = 0; i < num; i++) {
				sumScore += list[i][0];
				sumCal += list[i][1];
			}
			
			if(sumCal <= L && sumScore > result) {
				result = sumScore;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			list[depth] = data[i];
			comb(i+1, depth+1, num);
		}
	}
	
}