package day0818;

import java.util.Scanner;

public class EdgeListTest {
	
	static class Edge{
		public int from, to;

		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + "]";
		}
		
	}
	
	static int N;
	static Edge[] edgeList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점수
		int C = sc.nextInt(); // 간선수
		
		edgeList = new Edge[C];
		for(int i=0; i<C; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			edgeList[i] = new Edge(from,to);
		}
		print();
	}
	
	private static void print() {
		for (Edge edge : edgeList) {
			System.out.println(edge);
		}
	}
}
