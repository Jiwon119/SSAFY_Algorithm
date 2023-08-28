package day0827;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {
	
	public static int N, wList[], numList[], result;
	public static boolean numVisited[];
	
	// 1. 숫자를 어떤 순서로 넣을건지 정함 -> 순열
	// 2. 오른쪽에서 뽑을건지 왼쪽에서 뽑을건지 정함 -> 부분집합
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("src/day0827/3234_input.txt")));
		
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
			
			numList = new int[N];
			numVisited = new boolean[N];
			result= 0;

			setNum(0);

			sb.append('#').append(T).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void setNum(int depth) {
		if(depth == N) {
			getResult(0,0,0);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(numVisited[i]) continue;
			
			numVisited[i] = true;
			numList[depth] = wList[i];
			setNum(depth+1);
			numVisited[i] = false;
			
		}		
	}

	private static void getResult(int depth, int left, int right) {
		if(depth == N) {
			if(left >= right) result++;
			return;
		}
		if(left < right) return;
		
		getResult(depth+1, left+numList[depth], right);
		getResult(depth+1, left, right+numList[depth]);

	}
	
	
	

}
