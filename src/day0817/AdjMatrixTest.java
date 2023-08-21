package day0817;

import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrixTest {

	static int N;
//	static boolean adjMatrix[][];
	static int adjMatrix[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점수
		int C = sc.nextInt(); // 간선수
		
//		adjMatrix = new boolean[N][N];
		adjMatrix = new int[N][N];
		for(int i=0; i<C; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
//			adjMatrix[to][from] = adjMatrix[from][to] = true;
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		print();
	}
	
	private static void print() {
//		for (boolean[] a : adjMatrix) {
		for (int[] a : adjMatrix) {
			System.out.println(Arrays.toString(a));
		}
	}
}