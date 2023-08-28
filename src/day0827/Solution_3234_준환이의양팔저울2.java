package day0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울2 {
	
	public static int N, wList[], orderList[], numList[], result;
	public static boolean orderVisited[], numVisited[];
	public static LinkedList<int[]> order;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= TestCase; T++) {
			N = Integer.parseInt(br.readLine());
			
			wList = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				wList[i] = Integer.parseInt(st.nextToken());
			}
			
			order = new LinkedList<int[]>();
			result = 0;
			numList = new int[N];
			numVisited = new boolean[N];
			orderVisited = new boolean[N];
			
			setNumList(0);
			
			sb.append('#').append(T).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void setNumList(int depth) {
		if(depth == N) {
			getResult(0,0,0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(numVisited[i]) continue;
			
			numVisited[i] = true;
			numList[depth] = wList[i];
			setNumList(depth+1);
			numVisited[i] = false;
		}
	}
	
	public static void getResult(int idx, int left, int right) {
		if(idx == N) {
			if(left >= right) {
				result++;				
			}
			return;
		}
		if(right > left) return;
		
		getResult(idx+1, left+numList[idx], right);
		getResult(idx+1, left, right+numList[idx]);		
	}	
}