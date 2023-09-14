package lv2;

import java.util.Arrays;

public class FindBigNumber { // 뒤에 있는 큰 수 찾기

	public static void main(String[] args) {
		FindBigNumber main = new FindBigNumber();

		// [3, 5, 5, -1]
//		int[] numbers = { 2, 3, 3, 5};

		// [-1, 5, 6, 6, -1, -1]
//		int[] numbers = { 9, 1, 5, 3, 6, 2 };
		
		// [2, 99, 99, 99, 99, 99, 99, 99, 99, 99, -1]
		int[] numbers = { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 99 };

		System.out.println(Arrays.toString(main.solution(numbers)));
	}

	// 21, 22 시간초과
	private int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Arrays.fill(answer, -1);
		
		int maxIdx = numbers.length-1;
		for (int i = numbers.length-2; i >= 0; i--) {			
			if(numbers[i] == numbers[i+1]) {
				answer[i] = answer[i+1];
			} else if(numbers[i] < numbers[i+1]) {
				answer[i] = numbers[i+1];
				if(numbers[maxIdx] < numbers[i+1]) {
					maxIdx = i+1;
					System.out.println(maxIdx);
				}
			} else {
				if(numbers[i] > numbers[maxIdx]) {
					maxIdx = i;
					continue;
				}
				for (int j = i+1; j <= maxIdx; j++) {
					System.out.println("들어왔다");
					if(numbers[i] < answer[j]) {
						answer[i] = answer[j];
						break;
					}
				}
			}
			System.out.println("maxIdx = " + maxIdx + ", " + Arrays.toString(answer));
		}
		
		return answer;
	}

	// 20 ~ 23 시간초과
//	private int[] solution(int[] numbers) {
//		int[] answer = new int[numbers.length];
//		
//		for (int i = 0; i < numbers.length; i++) {
//			if(i == numbers.length-1) {
//				answer[i] = -1;
//				continue;
//			}
//			
//			for (int j = i+1; j < answer.length; j++) {
//				if(numbers[i] < numbers[j]) {
//					answer[i] = numbers[j];
//					break;
//				}
//			}
//			
//			if(answer[i] == 0) {
//				answer[i] = -1;
//			}
//		}
//		
//		return answer;
//	}

}
