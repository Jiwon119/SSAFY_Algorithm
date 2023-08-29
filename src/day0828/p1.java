package day0828;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1 {
	
	public static int result;
	public static int N, pNum[], areaA[], areaB[];
	public static boolean visitedA[], visitedB[], flag;
	
	public static List<Integer>[] graph;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		StringBuilder sb = new StringBuilder();
		
		int TestCase = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= TestCase; T++) {
			result = Integer.MAX_VALUE;
			flag = false;
			
			N = Integer.parseInt(br.readLine());
			
			graph = new LinkedList[N];
			for (int i = 0; i < N; i++) {
				graph[i] = new LinkedList<Integer>();
			}
			
			// 그래프에 마을 정보 입력
			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(tk.nextToken());
					if(n == 1) {
						graph[i].add(j);
					}
				}
			}
			
			pNum = new int[N];
			tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pNum[i] = Integer.parseInt(tk.nextToken());
			}

			
			// 1개부터 N/2개 까지 조합으로 돌림.
			for (int i = 1; i <= N/2; i++) {
				areaA = new int[i];
				areaB = new int[N-i];

				comb(0,0,i);
			}
			
			sb.append('#').append(T).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void comb(int depth, int start, int size) {
		if(depth == size) {
			
			int idxA = 0, idxB = 0;
			for (int i = 0; i < N; i++) {
				if(idxA < areaA.length && i == areaA[idxA]) {
					idxA++;
				}else {
					areaB[idxB++] = i;
				}
			}

			visitedA = new boolean[N];
			visitedB = new boolean[N];
			
			if(!check(areaA, visitedA)) return;
			if(!check(areaB, visitedB)) return;

			flag = true;
			getResult();
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			areaA[depth] = i;
			comb(depth+1, i+1, size);
		}
		
	}
	public static boolean check(int[] arr, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(arr[0]);
		visited[arr[0]] = true;
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			for (int i = 0; i < graph[num].size(); i++) {
				for (int j = 0; j < arr.length; j++) {
					if(graph[num].get(i) == arr[j] && !visited[arr[j]]) {
						queue.add(arr[j]);
						visited[arr[j]] = true;
					}
				}
			}
		}
		
		for (int i : arr) {
			if(!visited[i]) return false;
		}
		
		return true;
	}
	
	public static void getResult() {
		int sumA = 0, sumB = 0;
		
		for (int i = 0; i < areaA.length; i++) {
			sumA += pNum[areaA[i]];
		}
		
		for (int i = 0; i < areaB.length; i++) {
			sumB += pNum[areaB[i]];
		}
		
		result = Math.min(result, Math.abs(sumA-sumB));
	}
}
