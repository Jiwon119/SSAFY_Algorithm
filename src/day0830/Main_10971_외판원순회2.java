package day0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {
	
	public static int N, city[], cost[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N의 개수만큼 순열
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		city = new int[N];
		for (int i = 0; i < N; i++) {
			city[i] = i;
		}
		
		int result = Integer.MAX_VALUE;
		do {
			int sum = 0;
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				if(cost[city[i]][city[(i+1)%N]] == 0) {
					flag = false;
					break;
				}
				sum += cost[city[i]][city[(i+1)%N]];
			}
			if(flag) {
				result = Math.min(result, sum);
			}
		}while(np());
		
		
		System.out.println(result);
		
		
	}
	
	public static boolean np() {
		int i = N-1;
		while(i > 0) {
			if(city[i-1] < city[i]) break;
			i--;
		}
		if(i == 0) return false; // 순열 끝난거임 
		
		int j = N-1;
		while(j > i) {
			if(city[j] >= city[i-1]) break;
			j--;
		}
		
		int tmp = city[i-1];
		city[i-1] = city[j];
		city[j] = tmp;
		
		
		// i이후로 리버스
		int z = N-1;
		while(z > i) {
			tmp = city[z];
			city[z] = city[i];
			city[i] = tmp;
			z--;
			i++;
		}
		
		
		return true;
	}
}
