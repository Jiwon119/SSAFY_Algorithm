package day0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//프림 알고리즘이용
/*

5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0
==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0
==>175
*/

public class PrimAlgorithm_인접행렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N][N];
        boolean[] visited = new boolean[N];
        int[] minEdge = new int[N];
		
		
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
        
        int minVertex,min,result = 0;
        minEdge[0] = 0; // 임의의 시작점 비용 0 셋팅
		
        for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;
        	minVertex = i;
        	
        	
		}
		
		
		
		
		
		
	}
}
