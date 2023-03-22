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
		int[] numArr = new int[n*n];
		
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] += i%n + 1;
//			System.out.println(Arrays.toString(numArr));
			if(i%n == 0) {
				for (int j = 0; j < i/n; j++) {
					numArr[i+j] += i/n-j;
//					System.out.println("i+j = " + (i + j));
//					System.out.println("i/n = " + i/n);
				}
			}
//			System.out.println(Arrays.toString(numArr));
		}
		
//		System.out.println(Arrays.toString(numArr));
		
		int[] answer = Arrays.copyOfRange(numArr, (int)left, (int)right+1);
		
		return answer;
	}

}
