package lv2;

import java.util.Arrays;

public class DifferentBits { // 2개 이하로 다른 비트

	public static void main(String[] args) {
		int[] numbers = { 2, 7 };
		System.out.println(solution(numbers));
	}

	private static long[] solution(int[] numbers) {
		long[] answer = new long[numbers.length];
		
		// 비트로 변환
		for(int i=0; i<numbers.length; i++) {
			String bytes1 = Integer.toBinaryString(numbers[i]);
			if()
			
			
		}

//		System.out.println(Arrays.toString(answer));
		
		return answer;
	}

}
