package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveMin {  // 제일 작은 수 제거하기
	
	private int[] solution(int[] arr) {
		List<Integer> answer = new ArrayList<Integer>();
		
		int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			answer.add(arr[i]);
			if(min > arr[i]) {
				minIdx = i;
				min = arr[i];
			}
		}
//		System.out.println(min);
		answer.remove(minIdx);
		if(answer.isEmpty()) answer.add(-1);
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
	
	private int[] solution1(int[] arr) {
		int min = Arrays.stream(arr).min().getAsInt();
		
		return (arr.length == 1)?new int[] {-1}:Arrays.stream(arr).filter(i -> i != min).toArray();
	}

	public static void main(String[] args) {
		RemoveMin main = new RemoveMin();
		
		int[] arr = {4, 3, 2, 1};
//		int[] arr = {10};
		
		System.out.println(Arrays.toString(main.solution(arr)));
		System.out.println(Arrays.toString(main.solution1(arr)));
	}

}
