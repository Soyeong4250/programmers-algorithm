package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Compact { // 압축

	public static void main(String[] args) {
		Compact main = new Compact();

//		String msg = "KAKAO";
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
//		String msg = "ABABABABABABABAB";

		System.out.println(main.solution(msg));
	}

	private List solution(String msg) {
		List<Integer> answer = new ArrayList<>();
		
		HashMap<String, Integer> dict = new HashMap<>();
		
		int alphabet = 65;
		
		for (int i = 0; i < 26; i++) {
			dict.put(String.valueOf((char)(alphabet+i)), i+1);
		}
		int end = 26;
		
		System.out.println(dict);
		
		int idx = 0;
		while(msg.trim().length() > 0) {
			System.out.println(msg.length());
			for (int i = msg.length(); i >= 0; i--) {
				if(dict.containsKey(msg.substring(0, i))) {
					answer.add(dict.get(msg.substring(0, i)));
					
					if(i+1 >= msg.length()) {
						i = msg.length() - 1;
					}
					dict.put(msg.substring(0, i+1), ++end);
					idx = i;
				}
			}
			if(idx == msg.length() - 1) {
				break;
			}
			
			msg = msg.substring(idx);
			System.out.println("dict = " + dict);
			System.out.println("msg = "+ msg);
			System.out.println("idx = " + idx);
		}
		
		return answer;
	}

}
