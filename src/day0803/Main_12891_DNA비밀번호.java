package day0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {
	
	static int A, C, G, T;
	static HashMap<Character, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		
		token = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(token.nextToken());
		int p = Integer.parseInt(token.nextToken());
		
		String str = br.readLine();
		
		token = new StringTokenizer(br.readLine());
		A = Integer.parseInt(token.nextToken());
		C = Integer.parseInt(token.nextToken());
		G = Integer.parseInt(token.nextToken());
		T = Integer.parseInt(token.nextToken());

		int result = 0;

		for (int i = 0; i < p; i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
		}
		if(check()) result++;
	
		for (int i = p; i < s; i++) {
			map.put(str.charAt(i-p), map.getOrDefault(str.charAt(i-p),0)-1);
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
			
			if(check()) result++;
		}
		System.out.println(result);
	}	
	public static boolean check() {
		if(map.getOrDefault('A', 0) < A || map.getOrDefault('C',0) < C ||
				map.getOrDefault('G',0) < G || map.getOrDefault('T',0) < T) {
			return false;
		}
		return true;
	}
}