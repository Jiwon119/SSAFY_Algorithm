package day0829;

import java.util.Scanner;

public class DP_2_막대연결하기2 {
    public static void main(String[] args) {
 	   //f(1)=2     f(2)=5      f(3)=12       f(4)=29      f(5)=70      f(6)=169
 	   
       //1,2, 3, 4, 5 ==> 조건 , 입력값,   총길이cm
 	   //2,5,12,29,70 ==> 결과값, 출력값,  연결막대 조합에 대한 경우의 수
    	
    	
    	Scanner sc = new Scanner(System.in);
    	  int N=sc.nextInt();
    	  
    	  int []memo = new int[N+2];//미리 계산된 결과를 메모리에 저장
    	
    	  memo[1]=2;//이전이전항(인덱스1: 1cm 의미)
    	  memo[2]=5;//   이전항(인덱스2: 2cm 의미)
    	  
    	  //계산하기
    	  for(int i=3; i<=N; i++) {
    		memo[i] = memo[i-1]*2 + memo[i-2];
    	  }
    	  
    	  
    	  System.out.println(memo[N]);//결과값 cm에 대한 경우의 수를 출력
    	  sc.close();
	}//main
}
