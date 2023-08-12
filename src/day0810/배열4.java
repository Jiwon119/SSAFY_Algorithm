package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 배열4 {
	
	static class Rect{//회전할 부분사각형 연산의 정보
		int row;
		int col;
		int size;
		
		public Rect(int row, int col, int size) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
		}

	}//class Rect
	
	static int N;//행
	static int M;//열
	static int K;//회전연산의 개수
		
	static int[][] map;//초기데이터 저장
	static int[][] mapClone;//초기 맵 복사(실행결과 저장)
	
	static Rect[] rects;// 회전정보 : 초기 위치(행, 열, 크기)
	static Rect[] rectsPerm; //순열 결과(순서) 저장
	
    static int[] dy = { 1,  0, -1,  0 };//행인덱스
    static int[] dx = { 0,  1,  0, -1 };//열인덱스
	                 //[하, 우,  상, 좌]
                     //=>[상->하, 좌->우, 하->상, 우->좌] 으로 사용
    
	static boolean[] visited; //순열에 사용
	static int min;//회전후 최소값
	static int result;//최종 값	
	

	public static void main(String[] args) throws Exception{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	  StringTokenizer tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());//행
		M = Integer.parseInt(tokens.nextToken());//열
		K = Integer.parseInt(tokens.nextToken());//회전연산의 개수	  
		
		//입력된 데이터와 배열인덱스 맞추어주기
		map      = new int[N + 1][M + 1];
		mapClone = new int[N + 1][M + 1];		

		rects     = new Rect[K];
		rectsPerm = new Rect[K];
		
		visited = new boolean[K];    
		
		//배열 데이터 입력
		for (int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}		
		
		//연산 데이터 입력
		for (int i = 0; i < K; i++) {
			rects[i] = new Rect(Integer.parseInt(tokens.nextToken()),
					            Integer.parseInt(tokens.nextToken()),
							    Integer.parseInt(tokens.nextToken()));
		}
		
		//연산 순열 구하기
		result = Integer.MAX_VALUE;
		min = Integer.MAX_VALUE;		
		
		perm(0);
		
		System.out.println(result);
		
	    br.close();
	}//main

	
	/**
	 * 회전 연산에 대한 순열 구하기
	   2회 회전: [3 4 2] [4 2 1]
	   2회 회전: [4 2 1] [3 4 2]	
	   
	 */	
	private static void perm(int depth) {
		
	  if(depth == K) {//연산 순열이 다 만들어졌다면
		for(int i=1; i<=N; i++) {
			System.arraycopy(map[i], 1, mapClone[i], 1, M);
		}
		  
		//순열이 준비되었다면 해당 순열의 회전 연산 처리하기
		startRotate();
		
		result = Math.min(result, min); //배열 돌리고 최솟값 저장 
		
		return;
	  }//순열 생성
		
		
	  for(int i=0; i<K; i++) {
		 if(!visited[i]) {
			 visited[i]=true;
			 			 
			 rectsPerm[depth] = rects[i];
			 perm(depth+1);
			 
			 visited[i]=false;
		 }
	  }
		
	}//perm


	private static void startRotate() {
		// tempArr사용
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < rectsPerm.length; i++) {
			arrRotate(rectsPerm[i]);
		}

		// 배열을 다 돌린 후의 각 행의 최소값 찾기
		int sum = 0;
		for (int j = 1; j <= N; j++) {
			sum = 0;
			for (int k = 1; k <= M; k++) {
				sum += mapClone[j][k];
			}
			min = Math.min(sum, min);
		}		
		
	}


	private static void arrRotate(Rect rect) {
		int R = rect.row;
		int C = rect.col;
		int S = rect.size;
		
		for (int i = 0; i < S; i++) {
            int dir = 0;//하  우  상 좌
            int sy = R-S+i; //rotate 시작위치 행
            int sx = C-S+i; //rotate 시작위치 열
            int value = mapClone[sy][sx];
            while (dir < 4) {//dir=0,1,2,3
                int ny = sy + dy[dir];
                int nx = sx + dx[dir];
 
                if (ny >= R-S+i && nx >= C-S+i && ny<=R+S-i && nx <= C+S-i) {//배열의 범위내에 있다면, 로테이션 범위안에 있다면
                	mapClone[sy][sx] = mapClone[ny][nx]; //값 시프트
 
                    sy = ny; //이동
                    sx = nx; //이동
                } else {
                    dir++;
                }
            }
            mapClone[R-S+i][C-S+i+1] = value;
	    }		
	}
}//class end

