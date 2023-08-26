package day0821;

import java.util.Arrays;
import java.util.Scanner;

// 무향 그래프
public class AdjListTest {
	
	static class Node{
		int vertext;	// 관계를 맺고 있는 타정점 정보
		Node next;		// 연결리스트 유지를 위한 다음 노드 참조
		
		public Node(int vertext, Node next) {
			super();
			this.vertext = vertext;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return "Node [vertext=" + vertext + ", next=" + next + "]";
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();	// 노드
		int E = sc.nextInt();	// 간선
		
		Node adjList[] = new Node[V];
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
			
		}
		for (Node node : adjList) {
			System.out.println(node);
		}
		dfs(adjList, new boolean[V], 0);

	}
	private static void dfs(Node adjList[], boolean[] visited, int current) {
		visited[current] = true;
		System.out.println((char) (current+65));
		
		//현 정점의 인접정점들 체크하며 대기열에 넣기
		for(Node temp = adjList[current]; temp != null; temp = temp.next) {
			if(!visited[temp.vertext]) {
				dfs(adjList, visited, temp.vertext);
			}
		}
	}
}
