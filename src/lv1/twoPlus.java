package lv1;

import java.util.Arrays;
import java.util.HashMap;

public class TwoPlus { // 두 개 뽑아서 더하기

	public static void main(String[] args) {
//		int[] numbers = { 2, 1, 3, 4, 1 };
		int[] numbers = {5, 0, 2, 7};

		System.out.println(solution(numbers));
	}

	private static int[] solution(int[] numbers) {
		HashMap<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if(i != j) {
					hash.put(numbers[i] + numbers[j], hash.getOrDefault(numbers[i] + numbers[j], 0) + 1);
				}
			}
		}
				
		int[] answer = new int[hash.size()];
		
		int idx = 0;
		for (int key:hash.keySet()) {
			answer[idx] = key;
			idx++;
		}
		Arrays.sort(answer);
//		System.out.println(Arrays.toString(answer));
		return answer;
	}

}
