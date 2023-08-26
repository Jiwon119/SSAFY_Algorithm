package day0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KruskalAlgorithm {
	/*

	<크루스칼 알고리즘 핵심>
	1. 간선의 정보를 모으고 가장 작은 가중치를 갖는 간선을 사용한다.
	  ==> 정렬이 필요(필수)
	  
	2. 작은 가중치를 갖는 간선을 V-1 만큼 선택하였을때 사이클이 발생할 수 있다.
	   ==> 사이클 발생 여부 확인 필요
	   ==> union, find를 통하여 해결
	   ==> 동일집합은 사이클이 있고 다른 집합은 사이클이 없다.
		 
	*/
		
	/*
	<실행 조건>
	정점의 개수 
	==> 1~100,000  십만
	스패닝 트리 : 간선의 개수는 정점의 개수-1  
	==> 99,999   구만구천

	가중치 최대==> -1,000,000 ~ 1,000,000  최대 : 백만

	99,999 * 1,000,000  = 99,999,000,000   9백9십억
	 */
	
	public static class Edge implements Comparable<Edge>{
		int to;		// 정점
		int from;	// 정점
		int weight;	// 가중치
		
		public Edge(int to, int from, int weight) {
			super();
			this.to = to;
			this.from = from;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static int V, E;
	public static int parents[];	//부모(대표)정보 저장
	public static Edge[] EdgeList;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= TestCase; T++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());	// 정점개수 (1 <= V <= 100,000)
			E = Integer.parseInt(st.nextToken());	// 간선개수 (1 <= E <= 200,000)
			
			EdgeList = new Edge[E];

			//간선 정보 저장
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());	// 정점A
				int to = Integer.parseInt(st.nextToken());		// 정점B
				int weight = Integer.parseInt(st.nextToken());	// 가중치 (-1,000,000 <= C <= 1,000,000)
				
				EdgeList[i] = new Edge(to, from, weight);
			}
			
			Arrays.sort(EdgeList);	//간선의 가중치에 대한 오름차순 정렬
			
			make();
			
			long result = 0;	//최소 스패닝 트리의 전체 가중치(가중치 합) 
			int cnt = 0;
			
			for (int i = 0; i < EdgeList.length; i++) {	//간선정보 만큼 반복
				if(cnt == V-1) break;
				
				//union성공 (최소 가중치 간선추가 성공)
				if(union(EdgeList[i].to, EdgeList[i].from)) {	//사이클이 발생하지 않았다면 (최소)간선 사용
					result += EdgeList[i].weight;	//이어진 간선의 가중치를 MST에 누적
					cnt++;
				}
			}
			
			sb.append('#').append(T).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
	
	//자신의 index값을 배열번지에 저장하여 각각의 집합을 만든다.
	public static void make() {
		parents = new int[V+1];	//정점 번호가 1부터 시작하므로 +1
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	// a의 집합을 찾아서 리턴 ==> 집합의 대표자 리턴
	// 대표자는 같은 집합인지 아닌지를 표현
	public static int find(int a) {
		if(parents[a] == a) {	//대표자가 자기자신
			return a;
		}
		return parents[a] = find(parents[a]);	// 대표자 찾기 재귀호출 + 최종 대표자 리턴
	}
	
	// a와 b의 두 집합을 하나의 집합으로 통합(서로 다른 집합일때) 
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;	// 두 집합이 같은 집합이면 ==> 사이클이 발생
		
		parents[bRoot] = aRoot;	// a집합에 b집합을 포함시킨다
		return true; // union성공 (최소 가중치 간선추가 성공)
	}
}