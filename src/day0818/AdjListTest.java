package day0818;

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
public class AdjListTest {

	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
	}
	
	static int N;
	static Node[] adjList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점수
		int C = sc.nextInt(); // 간선수
		
		adjList = new Node[N];
		for(int i=0; i<C; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from] = new Node(to,adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
		}
		
		bfs();
		sc.close();		
	}
	
	//매개변수대신 static Node[] adjList을 사용했어요
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
			for(Node temp=adjList[current]; temp != null; temp= temp.next) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
	
}
