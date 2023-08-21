package day0821;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class topologySort {
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 위상정렬에 사용할 진입차수 저장 배열
        int[] edgeCount =new int[8];
		
     // 위상정렬에 사용할 그래프 2차원 리스트로 구현
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= edgeCount.length; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		// 그래프 각 노드별 인접한 노드정보 초기화
		graph.get(1).add(2);
		graph.get(1).add(5);
		graph.get(2).add(3);
		graph.get(2).add(6);
		graph.get(3).add(4);
		graph.get(4).add(7);
		graph.get(5).add(6);
		graph.get(6).add(4);

		// 진입차수 테이블 초기화
		edgeCount[2] = 1;
        edgeCount[3] = 1;
        edgeCount[4] = 2;
        edgeCount[5] = 1;
        edgeCount[6] = 2;
        edgeCount[7] = 1;
		
        // 위상정렬에 사용할 큐
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i < edgeCount.length; i++) {
			if(edgeCount[i] == 0) {
				queue.offer(i);
			}
		}
        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
        	// 큐에서 노드번호 꺼내기
        	int nodeNo = queue.poll();
        	
        	// 꺼낸 노드번호 정렬 결과값에 저장
        	sb.append(nodeNo).append(' ');
        	
        	// 꺼낸 노드의 인접한 노드들 찾기
        	List<Integer> list = graph.get(nodeNo);
        	
        	// 인접한 노드의 개수만큼 반복문 실행
        	for (int i = 0; i < list.size(); i++) {
        		// 인접한 노드 진입차수 갱신
        		edgeCount[list.get(i)]--;
        		
        		 // 갱신된 노드의 진입차수가 0이면 큐에 노드 넣기
				if(edgeCount[list.get(i)] == 0) {
					queue.offer(list.get(i));
				}
			}
        	
        }
        System.out.println(sb);
	}
}
