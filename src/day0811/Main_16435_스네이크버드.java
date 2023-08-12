package day0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16435_스네이크버드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int L = Integer.parseInt(tk.nextToken());
		
		int[] fruit = new int[N];
		
		tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < fruit.length; i++) {
			fruit[i] = Integer.parseInt(tk.nextToken());
		}
		
		Arrays.sort(fruit);
		for (int i = 0; i < fruit.length; i++) {
			if(fruit[i] > L) {
				break;
			}
			L += 1;
		}
		System.out.println(L);
		
	}
}
