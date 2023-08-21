package day0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1247_최적경로_np {
	
	public static int data[][], N, Min, list[];
	public static boolean visited[];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		for (int T = 1; T <= testCase ; T++) {
			N = Integer.parseInt(br.readLine());
			data = new int [N+2][2];
			list = new int[N];
			visited = new boolean[N+2];
			Min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N+2; i++) {
				data[i][0] = Integer.parseInt(st.nextToken());
				data[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 2; i < N+2; i++) {
				list[i-2] = i;
			}
			
			do {
				int temp = getDistance();
				if(temp < Min) Min = temp;
				
			}while(np(list));

			sb.append('#').append(T).append(' ').append(Min).append('\n');
		}
		System.out.println(sb);

	}
	
	
	public static int getDistance() {
		int sum = 0;
		
		// 회사의 거리
		int x = data[0][0];
		int y = data[0][1];
		
		for (int i = 0; i < N; i++) {
			sum += Math.abs(x-data[list[i]][0]) + Math.abs(y-data[list[i]][1]);
			x = data[list[i]][0];
			y = data[list[i]][1];
		}
		sum += Math.abs(x-data[1][0]) + Math.abs(y-data[1][1]);
		
		return sum;
	}
	
	private static boolean np(int numbers[]) { // 다음 순열을 원하는 기존 순열의 배열

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
