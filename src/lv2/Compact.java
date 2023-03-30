package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Compact { // 압축

	public static void main(String[] args) {
		Compact main = new Compact();

		String msg = "KAKAO";
//		String msg = "TOBEORNOTTOBEORTOBEORNOT";
//		String msg = "ABABABABABABABAB";

		System.out.println(Arrays.toString(main.solution(msg)));
	}

	private int[] solution(String msg) {
		List<Integer> result = new ArrayList<>();
		
		HashMap<String, Integer> dict = new HashMap<>();
		
		int alphabet = 65;
		
		for (int i = 0; i < 26; i++) {
			dict.put(String.valueOf((char)(alphabet+i)), i+1);
		}
		int end = 26;
		
		System.out.println(dict);
		
		StringBuilder sb = new StringBuilder();
		while(msg.length() > 0) {
			sb.delete(0, sb.length());
			for (int i = msg.length(); i > 0; i--) {
				String w = msg.substring(0, i);
				if(dict.containsKey(w)) {
					result.add(dict.get(w));

					if(i < msg.length()) {
						sb.append(w).append(msg.charAt(i));
						dict.put(sb.toString() , ++end);
					}
					msg = msg.substring(i);
					break;
				}
			}
		}
		
		System.out.println(result);
		int[] answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}
		
		return answer;
	}

}
