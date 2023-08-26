package day0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tk.nextToken());	// 접시의 수
		int d = Integer.parseInt(tk.nextToken());	// 초밥 가짓수
		int k = Integer.parseInt(tk.nextToken());	// 연속해서 먹는 접시의 수
		int c = Integer.parseInt(tk.nextToken());	// 쿠폰 번호
		
		int data[] = new int[N+1];
		int cnt[] = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0, max = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < k; i++) {
			queue.add(data[i]);
			if(cnt[data[i]]++ == 0 && data[i] != c) {
				result++;
			}
		}
		
		for (int i = k; i < N+k; i++) {
			max = Math.max(max, result);
			int idx = i % N;
			
			int n = queue.poll();
			if(--cnt[n] == 0 && n != c) {
				result--;
			}
			
			queue.add(data[idx]);
			
			if(cnt[data[idx]]++ == 0 && data[idx] != c) {
				result++;
			}
		}
		
		System.out.println(max+1);
		
	}
}
