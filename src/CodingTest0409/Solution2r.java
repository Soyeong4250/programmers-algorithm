package CodingTest0409;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2r {

	public static void main(String[] args) {
//		String call = "abcabcdefabc";
//		String call = "abxdeydeabz";
//		String call = "abcabca";
		String call = "ABCabcA";
		
		System.out.println("정답 : " + solution(call));

	}

	private static String solution(String call) {
		String answer = call;
		
		call = call.toLowerCase();
		String subStr = "";
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < call.length(); i++) {
			list.add(call.substring(i, i+1));
		}
		
		HashMap<Character, Integer> isPattern= new HashMap<>();

		for (int i = 0; i < call.length(); i++) {
			isPattern.put(call.charAt(i), isPattern.getOrDefault(call.charAt(i), 0)+1);
		}
		
		int max = 0;
		for (char key : isPattern.keySet()) {
			max = Math.max(max, isPattern.get(key));
		}
		for (char key : isPattern.keySet()) {
			if(max == isPattern.get(key)) {
				answer = answer.replace(String.valueOf(key), "");
				answer = answer.replace(String.valueOf(key).toUpperCase(), "");
			}
		}

		return answer;
	}



}
