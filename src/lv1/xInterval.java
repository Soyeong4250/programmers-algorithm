package lv1;

import java.util.Arrays;

public class XInterval { // x만큼 간격이 있는 n개의 숫자

	public static void main(String[] args) {
//		int x = 2;
//		int n = 5;
//		int x = 4;
//		int n = 3;
		int x = -4;
		int n = 2;

		System.out.println(solution(x, n));
	}

	private static long[] solution(int x, int n) {
		long[] answer = new long[n];
		
		long idx = 0;
		for (int i = 0; i < answer.length; i++) {
			idx += x;
			answer[i] = idx;
		}
		
//		System.out.println(Arrays.toString(answer));
		return answer;
	}

}
