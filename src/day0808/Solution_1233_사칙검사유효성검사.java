package day0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙검사유효성검사 {
	// 루트노드엔 연산자만 가능
	// 부모 노드는 연산자 O 숫자 X
	// 단말 노드에 연산자 X 숫자 O
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		
		for (int T = 1; T <= 10; T++) {
			int num = Integer.parseInt(br.readLine());
			int result = 1;
			for (int i = 0; i < num; i++) {
				token = new StringTokenizer(br.readLine());
				
				String temp;
				if (token.countTokens() == 4) {
					// 단말 노드 X -> 연산자 O 숫자 X
					token.nextToken();
					temp = token.nextToken();
					if(temp.equals("+") || temp.equals("-") 
							|| temp.equals("*") || temp.equals("/")) {
						continue;
					}
				}else {
					// 단말 노드 O -> 연산자 X 숫자 O
					token.nextToken();
					temp = token.nextToken();
					if(temp.equals("+") || temp.equals("-") 
							|| temp.equals("*") || temp.equals("/")) {
						result = 0;
					}
				}
			}
			System.out.println("#" + T + " " + result);
		}
		
	}
}
