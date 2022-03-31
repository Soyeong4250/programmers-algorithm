package Greedy;

import java.util.Arrays;
import java.util.HashMap;

public class makeBigNumber { // 큰 수 만들기
	
	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
//		String number = "1231234";
//		int k = 3;
//		String number = "4177252841";
//		int k = 4;

		System.out.println(solution(number, k));
	}

	private static String solution(String number, int k) {
		String answer = "";
		k = number.length()-k;
		
		char[] ch = number.toCharArray();
		Arrays.sort(ch);
		System.out.println(Arrays.toString(ch));
		
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < number.length(); i++) {
			map.put(String.valueOf(number.charAt(i)), map.getOrDefault(String.valueOf(number.charAt(i)), 0) + 1);
		}
		
		System.out.println(map);
		
		return answer;
	}

}
