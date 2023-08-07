package day0807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_암호문 {
	public static void main(String[] args) throws Exception{
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer token;
		
		// 원본 암호문 길이	-> originLength
		// 원본 암호문		-> origin
		// 명령어 개수		-> commendLength
		int originLength, commendLength;
		LinkedList<Integer> origin = new LinkedList<Integer>();
		int x, y;
		
		// for문 10개의 테스트케이스
		for (int T = 1; T <= 10; T++) {
			origin.removeAll(origin);
			
			originLength = Integer.parseInt(br.readLine());
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < originLength; i++) {
				origin.add(Integer.parseInt(token.nextToken()));
			}
			commendLength = Integer.parseInt(br.readLine());

			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < commendLength; i++) {
				token.nextToken();
				x = Integer.parseInt(token.nextToken());
				y = Integer.parseInt(token.nextToken());
				
				for (int j = x; j < x+y; j++) {
					origin.add(j, Integer.parseInt(token.nextToken()));
				}
			}
			sb.append('#').append(T + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(origin.get(i)).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}

/*
 * 
11
449047 855428 425117 532416 358612 929816 313459 311433 472478 589139 568205 
7
I 1 5 400905 139831 966064 336948 119288 I 8 6 436704 702451 762737 557561 810021 771706 I 3 8 389953 706628 552108 238749 661021 498160 493414 377808 I 13 4 237017 301569 243869 252994 I 3 4 408347 618608 822798 370982 I 8 2 424216 356268 I 4 10 512816 992679 693002 835918 768525 949227 628969 521945 839380 479976 

*/
