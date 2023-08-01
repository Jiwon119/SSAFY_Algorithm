package day0801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_Flatten {
	public static int[] arr = new int [100];

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src\\day0801\\Flatten_input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(token.nextToken());
			}
			for (int i = 0; i < dump; i++) {
				Arrays.sort(arr);
				if(arr[99] - arr[0] <= 1)
					break;
				arr[0]++;
				arr[99]--;
			}
			Arrays.sort(arr);
			int result = arr[99]-arr[0];
			
			System.out.printf("#%d %d\n", test_case, result);
		}

	}
}
