package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_카드게임 {
	
	public static boolean[] visited;
	public static int[] arr, data2, data1;
	public static int result; 
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk;
		
		int tc = Integer.parseInt(br.readLine());
		data1 = new int[9];
		data2 = new int[9];
		
		for (int T = 1; T <= tc; T++) {
			boolean[] ck = new boolean[19];
			result = 0;
			visited = new boolean[9];
			arr = new int[9];
			
			tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				data1[i] = Integer.parseInt(tk.nextToken());
				ck[data1[i]] = true;
			}
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if(!ck[i]) data2[idx++] = i; 
			}
			dfs(0);
			sb.append("#").append(T+" ").append(result + " ").append(362880-result).append('\n');
		
		}
		System.out.println(sb);
		
	}
	
	public static void dfs(int depth) {
		if (depth == 9) {
			int r1=0, r2=0;
			for (int i = 0; i < 9 ; i++) {
				if(data1[i] > arr[i]) {
					r1 += data1[i]+arr[i];
				}else {
					r2 += data1[i]+arr[i];
				}
			}
			if(r1>r2) result++;
			
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			
			arr[depth] = data2[i];
			
			visited[i] = true;
			dfs(depth+1);
			visited[i] = false;			
		}
		
		
		
	}
}