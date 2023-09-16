package lv2;

import java.util.HashMap;

public class CutTheRollCake { // 롤케이크 자르기

	public static void main(String[] args) {
		CutTheRollCake main = new CutTheRollCake();

		// 2
		int[] topping = { 1, 2, 1, 3, 1, 4, 1, 2 };

		// 0
//		int[] topping = {1, 2, 3, 1, 4};

		System.out.println(main.solution(topping));
	}

	private int solution(int[] topping) {
		int answer = 0;
		
		HashMap<Integer, Integer> chulsu = new HashMap<>();
		HashMap<Integer, Integer> brother = new HashMap<>();
		
		for (int i = 0; i < topping.length; i++) {
			chulsu.put(topping[i], chulsu.getOrDefault(topping[i], 0) + 1);
		}
		
		for (int i = 0; i < topping.length; i++) {
			brother.put(topping[i], brother.getOrDefault(topping[i], 0) + 1);
			chulsu.put(topping[i], chulsu.get(topping[i]) - 1);
			if(chulsu.get(topping[i]) == 0) {
				chulsu.remove(topping[i]);
			}
			
			if(brother.size() == chulsu.size()) {
				answer += 1;
			}
		}
		
		return answer;
	}

}
