package lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayOfNumbers { // 나누어 떨어지는 숫자 배열

	public static void main(String[] args) {
		int[] arr = { 5, 9, 7, 10 };
		int divisor = 5;

//		int[] arr = {2, 36, 1, 3};
//		int divisor = 1;
//		
//		int[] arr = {3, 2, 8};
//		int divisor = 10;

		System.out.println(solution(arr, divisor));
	}

	private static int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%divisor == 0) {
				list.add(arr[i]);
			}
		}
		
		Collections.sort(list);
		if(list.size() == 0) {
			list.add(-1);
		}
		
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}

}
