package lv2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class PickTangerine { // 귤 고르기

	public static void main(String[] args) {
		PickTangerine main = new PickTangerine();

		int k = 6;
		int[] tangerine = { 1, 3, 2, 5, 4, 5, 2, 3 };

//		int k = 4;
//		int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

//		int k = 2;
//		int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};

		System.out.println(main.solution(k, tangerine));
	}

	private int solution(int k, int[] tangerine) {
		int answer = 0;
		
		HashMap<Integer, Integer> hash = new HashMap<>();
		
		for (int i = 0; i < tangerine.length; i++) {
			hash.put(tangerine[i], hash.getOrDefault(tangerine[i], 0) + 1);
		}
		
		answer = pick(tangerine.length - k, tangerine, hash);
		
		return answer;
	}

	private int pick(int k, int[] tangerine, HashMap<Integer, Integer> hash) {
//		System.out.println("k = " + k);
		
		// HashMap value 기준 정렬
		List<Map.Entry<Integer, Integer>> entries = hash.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toList());
		
//		for (Entry<Integer, Integer> entry : entries) {
//			System.out.println(entry.getKey() + ":" + entry.getValue());
//		}
		
		for (Entry<Integer, Integer> entry : entries) {
			if(entry.getValue() <= k) {
				k -= entry.getValue();
				hash.remove(entry.getKey());
//				System.out.println(k);
			}
			
			if(k == 0) {
				break;
			}
		}
		
//		for (Entry entry : hash.entrySet()) {
//			System.out.println(entry.getKey() + ":" + entry.getValue());
//		}
		
		return hash.size();
	}

}
