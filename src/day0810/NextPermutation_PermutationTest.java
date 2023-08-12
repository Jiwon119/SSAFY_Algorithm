package day0810;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation_PermutationTest {

	static int totalCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		int[] input = new int[N];
		int[] p = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		int cnt = 0;
		while(++cnt <= R) p[N-cnt] = 1;
		
		
		do {
			// p배열을 이용한 조합 확인
			for (int i = 0; i < N; i++) {
				if(p[i] == 0) continue;
				System.out.print(input[i] + "\t");
			}
			System.out.println();
		}while(np(p));
		
		System.out.println("총 경우의 수 : "+totalCount);
	}

	private static boolean np(int numbers[]) { // 다음 순열을 원하는 기존 순열의 배열
		totalCount++;
		
		// 1. 맨 뒤쪽부터 탐색하여 꼭대기 찾기
		int N = numbers.length;
		
		int i=N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		if(i==0) return false;
		
		// 2. 꼭대기 직전(i-1)위치에 교환할 한단계 큰 수 뒤쪽부터 찾기
		int j=N-1;
		while(numbers[i-1]>=numbers[j])	--j;
		
		// 3. 꼭대기 직전(i-1)위치의 수와 한단계 큰 수를 교환하기
		swap(numbers,i-1,j);
		
		//4. 꼭대기 자리부터 맨뒤까지의 수를 오ㅡㄻ차순의 형태로 바꿈
		int k = N-1;
		while(i<k) {
			swap(numbers,i++,k--);			
		}
		return true;
	}
	
	private static void swap(int numbers[],int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
