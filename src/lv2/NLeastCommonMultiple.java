package lv2;

import java.util.Arrays;

public class NLeastCommonMultiple { // N개의 최소공배수

	public static void main(String[] args) {
//		int[] arr = { 2, 6, 8, 14 };
//		int[] arr = {1, 2, 3};
		int[] arr = {3, 4, 9, 16};

		System.out.println(solution(arr));
	}

	private static int solution(int[] arr) {
		int answer = 0;
		long gcd = 0;
		long multiple = 0;
		
		Arrays.sort(arr);
		
		// 최대공약수 구하기 (유클리드 호제법)
		for(int i = 1;i < arr.length; i++) {
			if(gcd == 0) {
				gcd = GCD(arr[i], arr[i-1], gcd);
				multiple = arr[i] * arr[i-1];
			} else {
				gcd *= GCD(multiple/gcd, arr[i], gcd);
				multiple *= arr[i];
			}
//			System.out.println("multiple은 " + multiple + ", gcd는 " + gcd);
		}
		
		answer = (int)multiple/(int)gcd;
		
		return answer;
	}

	private static long GCD(long a, long b, long gcd) {
		if(b == 0) {
			gcd = a;
			return gcd;
		} else {
			return GCD(b, a%b, gcd);
		}
	}

}
