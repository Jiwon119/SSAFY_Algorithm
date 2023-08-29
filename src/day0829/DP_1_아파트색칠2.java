package day0829;

import java.util.Scanner;

public class DP_1_아파트색칠2 {
    public static void main(String[] args) {
       //f(1)=2     f(2)=3      f(3)=5       f(4)=8      f(5)=13      f(6)=21
 	   
 	   //1,2,3,4, 5, 6  ==> 조건 , 입력값,   아파트 층수
 	   //2,3,5,8,13,21  ==> 결과값, 출력값,  칠할수있는 경우의 수
    	Scanner sc = new Scanner(System.in);
    	  int N=sc.nextInt();
    	  
    	  int []memo = new int[N+2];//미리 계산된 결과를 메모리에 저장
    	
    	  memo[1]=2;//이전이전항(인덱스1: 1층 의미)
    	  memo[2]=3;//   이전항(인덱스2: 2층 의미)
    	  
    	  //계산하기
    	  for(int i=3; i<=N; i++) {
    		  memo[i] = memo[i-1] + memo[i-2];
    	  }
    	  
    	  
    	  System.out.println(memo[N]);//결과값 층에 대한 경우의 수를 출력
    	  sc.close();
	}//main
}