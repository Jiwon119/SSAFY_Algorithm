package day0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	
	public static int N, population[], areaA[], areaB[], result;
	public static boolean areaCheckA[], areaCheckB[], checkResult;
	public static List<Integer>[] graph;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		N = Integer.parseInt(br.readLine());
		result = Integer.MAX_VALUE;

		population = new int[N+1];
		tk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(tk.nextToken());
		}
		
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			tk = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(tk.nextToken());
			for (int j = 0; j < num ; j++) {
				graph[i].add(Integer.parseInt(tk.nextToken()));
			}
		}
		
		// 1개 고르는 선택지 ~ N/2까지
		for (int i = 1; i <= N/2; i++) {
			areaA = new int[i];
			areaB = new int[N-i];
			
			comb(0,1,i);	// 지역이 1부터 시작하기 때문에 start=1
		}
		if(checkResult) System.out.println(result);
		else System.out.println(-1);
	}
	
	public static void comb(int depth, int start, int size) {
		if(size == depth) {
			ABListSet();	// 지역 A, B 리스트 set
			
			areaCheckA = new boolean[N+1];
			areaCheckB = new boolean[N+1];
			if(!areaCheck(areaA, areaCheckA)) return;
			if(!areaCheck(areaB, areaCheckB)) return;
			
			getResult();
			return;
		}
		for (int i = start; i <= N; i++) {
			areaA[depth] = i;
			comb(depth+1, i+1, size);
		}
	}
	
	public static void ABListSet() {
		int Aidx = 0;
		int Bidx = 0;
		for (int i = 1; i <= N; i++) {
			if(i == areaA[Aidx]) {
				if(Aidx < areaA.length-1) Aidx++;
			}else {
				areaB[Bidx++] = i;
			}
		}
	}
	
	public static boolean areaCheck(int[] arr, boolean[] visitedArr) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(arr[0]);
		visitedArr[arr[0]] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();

			for (int i = 0; i < graph[num].size(); i++) {
				for (int j = 0; j < arr.length; j++) {
					if(graph[num].get(i) == arr[j] && !visitedArr[arr[j]]) {
						queue.add(arr[j]);
						visitedArr[arr[j]] = true;
					}
				}				
			}
		}
		for (int i : arr) {
			if(!visitedArr[i]) return false;
		}
		
		return true;
	}
	
	
	public static void getResult() {
		int Asum = 0, Bsum = 0;
		
		for (int i = 0; i < areaA.length; i++) {
			Asum += population[areaA[i]];
		}
		for (int i = 0; i < areaB.length; i++) {
			Bsum += population[areaB[i]];
		}
		
		if(result > Math.abs(Asum-Bsum)) {
			checkResult = true;
			result = Math.abs(Asum-Bsum);
		}
		
	}
	
}
