package day0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
	
	
	private static int day, month1, month3, year;
	private static int[] data;
	
	private static int total;
	
	public static void bfs(int m, int sum) {
		if(m > 12) {
			if(total > sum) total = sum;
			return;
		}
		// 재귀를 통한
		// 1일 -> 다음달
		bfs(m+1, sum + (data[m] * day));
		
		// 1달 -> 다음달
		bfs(m+1, sum + month1);
		
		// 3달 -> 다다다음달
		bfs(m+3, sum + month3);

	}
	
	

	public static void main(String[] args) throws Exception{
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token;
		
		int testcase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= testcase; T++) {
			token = new StringTokenizer(br.readLine());
			day = Integer.parseInt(token.nextToken());
			month1 = Integer.parseInt(token.nextToken());
			month3 = Integer.parseInt(token.nextToken());
			year = Integer.parseInt(token.nextToken());
			
			data = new int[13];
			token = new StringTokenizer(br.readLine());
			for (int i = 1; i < 13; i++) {
				data[i] = Integer.parseInt(token.nextToken());
			}
			
			// 1년 -> 끝 -> 초기값으로 설정
			total = year;

			bfs(1, 0);
			
			sb.append('#').append(T + " ").append(total).append('\n');
		}
		System.out.println(sb);
	}
}
