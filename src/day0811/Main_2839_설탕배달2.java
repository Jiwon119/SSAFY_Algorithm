package day0811;

import java.util.Scanner;

public class Main_2839_설탕배달2 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int num5 = N / 5;
		N = N % 5; 
		int result = -1;
		
		while(true) {
			if(N % 3 == 0) {
				result = num5 + N/3;
				break;
			}
			if(--num5<0) {
				break;
			}
			N += 5;
		}
		
		System.out.println(result);
	}
}
