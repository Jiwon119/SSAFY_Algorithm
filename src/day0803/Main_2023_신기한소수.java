package day0803;

import java.util.Scanner;

public class Main_2023_신기한소수 {
	
	static int N;
	static int[] first = {2,3,5,7};
	static int[] oddList = {1,3,5,7,9};
	static int result = 0;
	static int temp;
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int curCnt, int result) {
		if(curCnt == N) {
			sb.append(result).append('\n');
			return;
		}
		
		for (int i = 0; i < oddList.length; i++) {
			temp = result*10 + oddList[i];
			if(check(temp)) dfs(curCnt+1, temp); 

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for (int i = 0; i < 4; i++) {
			result = first[i];
			dfs(1, result);
		}
		System.out.println(sb);
	}
	
	static boolean check(int num) {
		int t = (int) Math.sqrt(num) + 1;
		
		for (int i = 3; i < t; i+=2) {
			if(num%i == 0) return false;
		}
		
		return true;
	}
}
