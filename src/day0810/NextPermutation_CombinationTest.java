package day0810;

import java.util.Scanner;

public class NextPermutation_CombinationTest {

	static int N,R;
	static int[] input,p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		p = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		// 배열 뒤부터 R개수만큼 1로 만듦 : 5C2라면 00011 이런형태로
		int cnt=0;
		while(++cnt<=R) {
			p[N-cnt] = 1;
		}
		
		do {
			for(int i=0; i<N; ++i) {
				if(p[i]==1) System.out.print(input[i]+" ");
			}
			System.out.println();
		}while(np(p));
		
	}
	private static boolean np(int numbers[]) {
		int i=N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		if(i==0) return false;
		
		int j=N-1;
		while(numbers[i-1]>=numbers[j])	--j;
		swap(numbers,i-1,j);
		
		int k=N-1;
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
