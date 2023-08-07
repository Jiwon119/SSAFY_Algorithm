package day0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {
	public static void main(String[] args) throws Exception{
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(token.nextToken());
		int k = Integer.parseInt(token.nextToken());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		sb.append('<');
		int idx = k-1;
		
		while(list.size() > 1) {
			sb.append(list.get(idx)).append(", ");
			list.remove(idx);
			idx += k-1;
			while(idx >= list.size()) {
				idx -= list.size();
			}
		}
		sb.append(list.pop());
		
		sb.append('>');
		System.out.println(sb);
	}
}