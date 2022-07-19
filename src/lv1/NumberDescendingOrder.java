package lv1;

import java.util.Arrays;
import java.util.Collections;

public class NumberDescendingOrder {  // 정수 내림차순으로 배치하기

	public static void main(String[] args) {
		long n = 118372;
		
		System.out.println(solution(n));
	}
	
	private static long solution(long n) {
		long answer = 0;
		
		String num = String.valueOf(n);
		String[] order = num.split("");
		Arrays.sort(order, Collections.reverseOrder());
		answer = Long.parseLong(String.join("", order));
		
		return answer;
	}

}
