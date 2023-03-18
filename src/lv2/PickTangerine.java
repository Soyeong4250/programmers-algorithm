package lv2;

import java.util.HashMap;

public class PickTangerine { // 굴 고르기

	public static void main(String[] args) {
		PickTangerine main = new PickTangerine();

//		int k = 6;
//		int[] tangerine = { 1, 3, 2, 5, 4, 5, 2, 3 };

//		int k = 4;
//		int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

		int k = 2;
		int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};

		System.out.println(main.solution(k, tangerine));
	}

	private int solution(int k, int[] tangerine) {
		int answer = 0;
		
		HashMap<Integer, Integer> hash = new HashMap<>();
		
		for (int i = 0; i < tangerine.length; i++) {
			hash.put(tangerine[i], hash.getOrDefault(tangerine[i], 0) + 1);
		}
		
		answer = pick(tangerine.length - k, tangerine, new boolean[tangerine.length], hash, hash.size());
		
		return answer;
	}

	private int pick(int k, int[] tangerine, boolean[] check, HashMap<Integer, Integer> hash, int min) {
//		System.out.println(k);
		if(k <= 0) {
//			System.out.println("k가 0이하" + hash);
			if(min > hash.size()) {
//				System.out.println("min 변경 = " + hash.size());
				min = hash.size();
			}
			return min;
		}
		
		for (int i = 0; i < tangerine.length; i++) {
			if(!check[i]) {
				check[i] = true;
				hash.put(tangerine[i], hash.get(tangerine[i])-1);
				if(hash.get(tangerine[i]) == 0) hash.remove(tangerine[i]);
				min = pick(k-1, tangerine, check, hash, min);
				hash.put(tangerine[i], hash.getOrDefault(tangerine[i], 0) + 1);
				check[i] = false;
			}
		}
		
		return min;
	}

}
