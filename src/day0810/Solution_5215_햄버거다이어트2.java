package day0810;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트2 {
	
	static int result, N, L, cal[], score[];
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream(new File("src\\day0810\\5215_input.txt")));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk;
		
		int testcase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= testcase; T++) {
			tk = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(tk.nextToken());
			L = Integer.parseInt(tk.nextToken());
			
			cal = new int[N];
			score = new int[N];
			
			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(tk.nextToken());
				cal[i] = Integer.parseInt(tk.nextToken());
			}
			result = 0;
			comb(0,0,0,0);
			
			sb.append('#').append(T).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
		
	}
	
	public static void comb(int start, int depth, int sumCal, int sumScore) {
		
		if(sumCal <= L) result = Math.max(sumScore, result);
		if(depth == N) return;
		for (int i = start; i < N; i++) comb(i+1, depth+1, sumCal+cal[i], sumScore+score[i]);
		
		
	}
}