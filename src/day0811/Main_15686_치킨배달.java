
package day0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	public static int M, data[][], Min, selectedChicken[][];
	public static LinkedList<int[]> chicken = new LinkedList<>();
	public static LinkedList<int[]> house = new LinkedList<>();
	
	public static void comb(int depth, int start) {
		if(depth == M) {
			getDistance();
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			selectedChicken[depth] = chicken.get(i);
			comb(depth+1, i+1);
		}
	}
	
	public static void getDistance() {
		int[] result = new int[house.size()];
		for (int i = 0; i < house.size(); i++) {
			result[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < selectedChicken.length; i++) {
			for (int h = 0; h < house.size(); h++) {
				int temp = Math.abs(selectedChicken[i][0]-house.get(h)[0])+
						   Math.abs(selectedChicken[i][1]-house.get(h)[1]);
				result[h] = Math.min(result[h], temp);
			}
		}
		
		int sum = 0;
		for (int i = 0; i < result.length; i++) {
			sum += result[i];
		}
		Min = Math.min(Min, sum);
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tk.nextToken());	// N*N 크기의 도시
		M = Integer.parseInt(tk.nextToken());	// 치킨집의 최대 개수
		Min = Integer.MAX_VALUE;
		data = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(tk.nextToken());
				if(data[i][j]==2) {
					chicken.add(new int[] {i, j});
				}
				if(data[i][j] == 1) {
					house.add(new int[] {i, j});
				}
			}
		}

		
		
		selectedChicken = new int[M][2];
		comb(0,0);
		System.out.println(Min);
		
	}
}
