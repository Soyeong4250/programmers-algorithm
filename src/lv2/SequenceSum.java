package lv2;

import java.util.Arrays;
import java.util.HashSet;

public class SequenceSum { // 연속 부분 수열 합의 개수

	public static void main(String[] args) {
		SequenceSum main = new SequenceSum();

		int[] elements = { 7, 9, 1, 1, 4 };
		System.out.println(main.solution(elements));
	}

	private int solution(int[] elements) {
		HashSet<Integer> hash = new HashSet<>();
		
		int[] sum = new int[elements.length];
		
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < elements.length; j++) {
				sum[i] += elements[(i+j)%elements.length];
				hash.add(sum[i]);
			}
			System.out.println(hash);
		}
		
		return hash.size();
	}

}
