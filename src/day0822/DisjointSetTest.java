package day0822;

public class DisjointSetTest {
	
	static int N;	// 초기 집합의 개수 ()
	static int parents[];
	
	private static void make() { // 서로소 집합을 만드는 함수
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;	// 모든 요소는 자기만 원소로 갖는 단위 서로 집합이 되게 한다. (자신이 곧 대표자인 루트로 표현)
		}
	}
	
	private static int find(int a){
		if(a == parents[a]) return a;		
		return find(parents[a]);
	}
	
	private static boolean union(int a, int b) {	
		// a가 속한 집합과 b가 속한 집합을
		// 합칠수 있다면 합치고 true 반환 / 아니면 fasle 반환
		
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 서로의 대표자가 같은 즉, 같은 집합의 상황이므로 union하지 않음.
		if(aRoot == bRoot)	return false;	
		
		// union 처리 (bRoot를 aRoot 아래로 붙이기 !! : 임의로 ..)
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		N = 5;
		
		make();
		System.out.println(find(0));
		System.out.println(find(1));
		System.out.println(find(2));
		System.out.println(find(3));
		System.out.println(find(4));
		System.out.println(find(5));
		
		
		
		
		
		
	}
}
