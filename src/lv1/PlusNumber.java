package lv1;

import java.util.Arrays;
import java.util.HashMap;

public class PlusNumber {  // 없는 숫자 더하기

	public static void main(String[] args) {
//		int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
		int[] numbers = {5, 8, 4, 0, 6, 7, 9};
		
		System.out.println(solution(numbers));
	}

//	private static int solution(int[] numbers) {
//		int answer = 0;
//		
//		// 정렬
//		Arrays.sort(numbers);
//		
//		boolean[] num = new boolean[10];
//		
//		for (int i = 0; i < numbers.length; i++) {
//			num[numbers[i]] = true;
//		}
//		
//		for (int i = 0; i < num.length; i++) {
//			if(num[i] == false) {
//				answer += i;
//			}
//		}
//		
//		return answer;
//	}
	private static int solution(int[] numbers) {
		int answer = 45;  // 0~9 모두 더한 값
		
		for (int i:numbers) {
			answer -= i;
		}
		
		return answer;
	}

}
