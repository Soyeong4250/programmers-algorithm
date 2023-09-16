package lv1;

import java.util.Arrays;
import java.util.HashMap;

public class RoughKeyboard { // 대충 만든 자판

	public static void main(String[] args) {
		RoughKeyboard main = new RoughKeyboard();

		// [9, 4]
//		String[] keymap = { "ABACD", "BCEFD" };
//		String[] targets = { "ABCD", "AABB" };

		// [-1]
//		String[] keymap = {"AA"};
//		String[] targets = {"B"};

		// [4, 6]
		String[] keymap = {"AGZ", "BSSS"};
		String[] targets = {"ASA","BGZ"};

		System.out.println(Arrays.toString(main.solution(keymap, targets)));

	}

	private int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		HashMap<String, Integer> key = new HashMap<>();
		
		for (int i = 0; i < keymap.length; i++) {
			String[] map = keymap[i].split("");
			
			for (int j = 0; j < map.length; j++) {
				if(key.containsKey(map[j]) && key.get(map[j]) <= j+1) continue;
				key.put(map[j], j+1);
			}
		}
		
		System.out.println(key);
		
		for (int i = 0; i < targets.length; i++) {
			int cnt = 0;
			String[] targetArr = targets[i].split("");
			
			for (int j = 0; j < targetArr.length; j++) {
				if(key.containsKey(targetArr[j])) {
					cnt += key.get(targetArr[j]);
				} else {
					cnt = -1;
					break;
				}
			}
			
			answer[i] = cnt;
		}
		
		return answer;
	}

}
