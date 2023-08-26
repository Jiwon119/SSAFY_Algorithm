package day0821;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6



7
8
0 1
0 2
1 3
1 4
3 5
4 5
5 6
2 6
*/
public class AdjMatrixTest {

	static int N, adjMatrix[][];
	static boolean visited[];
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점수
		int C = sc.nextInt(); // 간선수
		
		adjMatrix = new int[N][N];
		
		for(int i=0; i<C; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
//		bfs();
		dfs(adjMatrix, new boolean[N], 0);
		sc.close();
	}	
	
	//들어갈때 방문 처리!
	//매개변수대신 static int [][]adjMatrix을 사용했어요
	//size대신 static int N을 사용했어요
	private static void bfs() {
		Queue<Integer>  queue = new ArrayDeque<>();//큐에 넣는 값은 방문대상을 관리할 값과 그밖의 값들을 넣을 수 있다.
		boolean visited[] = new boolean[N];
		
		//탐색시작점 정점0으로 하자
		queue.offer(0);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char)(current+65));
	
			//현 정점의 인접정점들 체크하며 대기열에 넣기
			for(int i=0; i<N; ++i) {
				if(adjMatrix[current][i] !=0 && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	private static void dfs(int[][] adMatrix, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println((char) (current+65));
		
		//현 정점의 인접정점들 체크하며 대기열에 넣기
		for(int i=0, size = adjMatrix.length; i < size; ++i) {
			if(adjMatrix[current][i] !=0 && !visited[i]) {
				dfs(adjMatrix, visited, i);
			}
		}
	}
	
	

}



