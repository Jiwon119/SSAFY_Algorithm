package day0811;

import java.util.Scanner;

public class Main_2839_설탕배달 {
	
	/**
	 * 문제
	 * 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램
	 * 봉지의 종류 - 3킬로그램, 5킬로그램
	 * */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		
		while(N > 0) {
			if(N % 5 == 0) {	// 5키로 봉지에 담을 수 있는 경우
				answer += N / 5;
				N %= 5;
				break;
			}
			// 5키로 봉지에 담을 수 없는 경우에는 3키로 봉지에 담는다.
			N -= 3;
			answer += 1;
		}
		
		// N이 0보다 작다면 정확하게 N킬로그램을 만들 수 없다는 의미이므로 -1을 출력한다.
		System.out.println(N < 0 ? -1 : answer);
	}
}