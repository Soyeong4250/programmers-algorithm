package lv2;

public class StandingLine { // 줄 서는 방법

	public static void main(String[] args) {
		int n = 3;
		long k = 5;

		System.out.println(solution(n, k));
	}

	private static int[] solution(int n, long k) {
		int[] answer = new int[n];
		
		// 1. 배열 입력
		int[] num = new int[n];
		for(int i=1; i <= n; i++) {
			num[i-1] = i;
		}
		
		int idx = 0;
		int m = 1;
		while(m < k) {
			idx++;
			m *= idx;
		}
		
		k -= m;  // 남은 조합의 횟수
		for(int i = 0 ; i < n - idx; i++) {
			answer[i] = i+1;
		}
		
		
		return answer;
	}

}
