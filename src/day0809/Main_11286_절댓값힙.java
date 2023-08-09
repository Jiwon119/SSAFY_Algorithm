package day0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {
	
	// 최소 힙
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());	// 연산의 개수 (1 <= N <= 100,000)
		
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			};
		});
		
		// 0이면 배열 꺼내서 출력 / 0이 아니면 그 값 삽입
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				queue.add(new int[] {Math.abs(num), num});
			}
			else {
				int[] re = queue.poll();
				if(re == null) {
					sb.append(0).append('\n');
				}else {
					sb.append(re[1]).append('\n');
				}
			}
		}
		System.out.print(sb);
	}
}
