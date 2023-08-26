package day0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	
	public static int N, start, result;
	public static Map<Integer, ArrayList<Integer>> map;
	public static Map<Integer, Boolean> visited;
	public static LinkedList<Integer> list = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int T = 1; T <= 10; T++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			map = new HashMap<Integer, ArrayList<Integer>>();
			visited = new HashMap<Integer, Boolean>();
			result = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(!map.containsKey(from)) {
					map.put(from, new ArrayList<Integer>());
				}
				if(!map.containsKey(to)) {
					map.put(to, new ArrayList<Integer>());
				}
				map.get(from).add(to);
				visited.put(from, false);
				visited.put(to, false);
			}
			
			bfs();
			for (int i = 0; i < list.size(); i++) {
				result = Math.max(result, list.get(i));
			}
			
			sb.append('#').append(T).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {start, 0});
		visited.put(start, true);
		
		
		int curDepth = -1;
		while(!queue.isEmpty()) {
			int[] num = queue.poll();

			
			for (int i = 0; i < map.get(num[0]).size(); i++) {
				int a = map.get(num[0]).get(i);
				if(visited.get(a)) continue;
				
				if(curDepth != num[1]) {
					list = new LinkedList<>();
					curDepth = num[1];
				}
				
				list.add(a);
				visited.put(a, true);
				queue.add(new int[] {a, num[1]+1});
			}
		}
	}
	
}
