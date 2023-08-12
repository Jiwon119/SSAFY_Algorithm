package day0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3040_백설공주와일곱난쟁이 {
	
	public static int combList[], data[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		data = new int[9];
		combList = new int[7];
		for (int i = 0; i < 9; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0);
	}
	public static void comb(int depth, int start) {
		if(depth == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += combList[i];
			}
			if(sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(combList[i]);
				}
			}
			return;
		}
		
		for (int i = start; i < data.length; i++) {
			combList[depth] = data[i];
			comb(depth+1, i+1);
		}
		
		
	}
	
}
