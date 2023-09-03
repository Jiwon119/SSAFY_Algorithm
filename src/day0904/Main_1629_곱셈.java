package day0904;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1629_곱셈 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long result[] = new long[6];
		if(b > 3) {
			long sum = 1;
			for (int i = 1; i <= 5; i++) {
				sum *= a;
				result[i] = sum % c;
			}
			System.out.println(Arrays.toString(result));
		}
		
		
		
		
	}
}
