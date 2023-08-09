package day0808;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {
	
	private static int n, m, max;
	private static int[] data, result;


	public static void Combination(int start, int depth) {
		// depth가 끝까지 선택되면
		if(depth == 2) {
			int sum = 0;
			for (int i : result) {
				sum += i;
			}
			if(sum <= m && sum > max) max = sum;
			return;
		}
		
		
		for (int i = start; i < n; i++) {
			if(data[i] > m) continue;
			result[depth] = data[i];
			Combination(i+1, depth+1);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		// 조합문제 but 완전탐색도 포함된 1-최대 과자 봉지수까지의 조합 구하기
		
		// 입력
		System.setIn(new FileInputStream(new File("src\\day0808\\9229_input.txt")));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk;
		
		int test_case = Integer.parseInt(br.readLine());
		for (int T = 1; T <= test_case; T++) {
			max = Integer.MIN_VALUE;
			
			tk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tk.nextToken());	// 과자봉지의 개수
			m = Integer.parseInt(tk.nextToken());	// 최대 무게
			
			tk = new StringTokenizer(br.readLine());
			data = new int[n];
			for (int i = 0; i < n; i++) {
				data[i] = Integer.parseInt(tk.nextToken());
			}
			
			result = new int[2];
			Combination(0,0);
			if(max == Integer.MIN_VALUE) max = -1;
			sb.append("#").append(T+" ").append(max).append('\n');
		}
		System.out.println(sb);
	}
}
