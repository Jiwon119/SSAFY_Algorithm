package day0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NextPermutation {
	
	public static int N, arr[], totalCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받은 수를 배열에 저장.
		String line = br.readLine();
		N = line.length();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = line.charAt(i) - '0';
		}
		
		Arrays.sort(arr);
		
		do {
			System.out.println(Arrays.toString(arr));
		}while(nextPermutation());
		
		System.out.println("총 경우의 수 : " + totalCnt);
		
	}

	/**
	 * 모든 탐색은 오른쪽에서 왼쪽으로 시작한다.
	 * 1. arr[i-1] < arr[i] 이 오른쪽에서 왼쪽으로 탐색하면서 제일처음 나오는 값을 찾는다.
	 * 2. 이제 i-1를 비교하면서  arr[i-1] < arr[j] 를 만족하는 값을 찾는다. (오른쪽에서 왼쪽탐색 시 처음나오는 값)
	 * 3. arr[i-1] 와 arr[j] 를 스왑한다.
	 * 4. i~N-1 까지의 순서를 reverse 해줍니다. (sort를 사용할 필요는 없고 양끝값을 swap해가면서 한칸식 줄여나갑니다)
	 * 
	 */
	
	public static boolean nextPermutation() {
		totalCnt++;
		
		int i = N-1;	// 맨 뒤부터 올라가면서 i-1<i 를 만족하는 것을 찾는다
		
		while(i>0 && arr[i-1] >= arr[i]) --i;	// 현재의 내 값보다 i-1이 커서 올라갈 수 있을때까지 올라간다.
		
		if(i == 0) return false;
		
		int j = N-1;	// i-1의 값과 바꿀 위치를 찾는다.
		
		while(arr[i-1] >= arr[j]) j--;
		
		// i-1의 자리의 숫자와 j자리의 숫자를 스왑한다.
		int temp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = temp;
		
		int k = N-1;
		while(i<k) { // i번째보다 큰 위치의 값들을 리버스 해준다.
			temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
			
			i++;
			k--;
		}
		
		
		return true;
	}
}
