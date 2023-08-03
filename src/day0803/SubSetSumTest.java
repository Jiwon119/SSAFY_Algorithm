package day0803;

import java.util.Scanner;

public class SubSetSumTest {
	
	static int N, Target, input[];
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Target = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
//		generateSubset(0);
		generateSubset2(0,0,0);
	}
	
	private static void generateSubset2(int cnt, int sum, int selectedCount) {	
		// cnt : 직전까지 고려된 원소의 개수, 현재 처리할 원소의 인덱스
		// sum : 직전까지 선택된 원소들의 합
		
		if(cnt == N) {
			if(sum == Target && selectedCount>0) {
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) {
						System.out.print(input[i] + "\t");
					}
				}
				System.out.println();
			}
			return;
		}
		isSelected[cnt] = true;
		generateSubset2(cnt+1, sum+input[cnt], selectedCount+1);
		isSelected[cnt] = false;
		generateSubset2(cnt+1, sum, selectedCount);
	}
	private static void generateSubset(int cnt) {	
		// cnt : 직전까지 고려된 원소의 개수, 현재 처리할 원소의 인덱스
		// sum : 직전까지 선택된 원소들의 
		
		if(cnt == N) {
			
			// 부분집합의 구성원소의 합을 구하고 sum과 비교
			int temp = 0, tCnt = 0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					temp += input[i];
					tCnt++;
				}
			}
			if(temp == Target && tCnt>0) {
				for (int i = 0; i < N; i++) {
					if(isSelected[i]) {
						System.out.print(input[i] + "\t");
					}
				}
				System.out.println();
			}
			return;
		}
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}
}