package day0808;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4008_숫자만들기 {
	
	public static int n, max, min;			//  n:숫자의 개수
	private static int[] op, data, result;	// op:연산자 개수 배열, data:숫자 배열, result:순열로 구한 연산자 배열
	
	// 연산자 순열 리스트 구하기
	public static void dfs(int idx) {
		// 깊이가 연산자의 개수만큼 깊어지면 return
		if(idx == n-1) {
			func();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (op[i] == 0) continue;
			
			op[i]--;			// 사용 했으니 방문체크 개념으로 연산자의 개수 한개 감소
			result[idx] = i;
			dfs(idx+1);
			op[i]++;			// 방문체크 해제 개념으로 연산자의 개수 한개 증가
		}
	}
	
	public static void func() {
		int temp = data[0];
		// 연산자에 따른 연산 결과 반환
		for (int i = 0; i < n-1; i++) {
			if(result[i] == 0) {
				temp += data[i+1];
			}else if(result[i] == 1) {
				temp -= data[i+1];
			}else if(result[i] == 2) {
				temp *= data[i+1];
			}else {
				temp /= data[i+1];
			}
		}
		if(temp > max) max = temp;
		if(temp < min) min = temp;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(new File("src\\day0808\\4008_input.txt")));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer tk;
		
		
		// 테스트 케이스 입력
		int test_case = Integer.parseInt(br.readLine());
		for (int T = 1; T <= test_case; T++) {
			n = Integer.parseInt(br.readLine());	// 숫자의 개수
			
			// 연산자 개수 입력
			op = new int[4];	// 각 연산자 개수 배열
			tk = new StringTokenizer(br.readLine());
			// 0:+  1:-  2:*  3:/  
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(tk.nextToken());
			}
			
			// 수식에 사용되는 숫자 입력
			data = new int[n];
			tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				data[i] = Integer.parseInt(tk.nextToken());
			}
			
			min = Integer.MAX_VALUE; 
			max = Integer.MIN_VALUE;
			result = new int[n-1];
			dfs(0);
			
			sb.append("#").append(T+" ").append(max - min).append('\n');
		}
		System.out.println(sb);
	}
	
	
}

	
		
