package lv2;

import java.util.Arrays;

public class CutArr { // n^2배열 자르기

	public static void main(String[] args) {
		CutArr main = new CutArr();

		int n = 3;
		long left = 2;
		long right = 5;

//		int n = 4;
//		long left = 7;
//		long right = 14;

		System.out.println(Arrays.toString(main.solution(n, left, right)));
	}

	private int[] solution(int n, long left, long right) {
		int[] answer = new int[(int)(right - left) + 1];
		
		for (long i = left; i <= right; i++) {
			answer[(int)(i-left)] = (int)Math.max(i/n, i%n) + 1;
		}
		
		return answer;
	}

}
