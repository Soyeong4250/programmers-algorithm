package lv1;

import java.util.Arrays;
import java.util.HashMap;

public class NumberPartner { // 숫자 짝꿍

	public static void main(String[] args) {
		NumberPartner main = new NumberPartner();

		// "-1"
//		String X = "100";
//		String Y = "2345";

		// "0"
		String X = "100";
		String Y = "203045";

		// "10"
//		String X = "100";
//		String Y = "123450";

		// "321"
//		String X = "12321";
//		String Y = "42531";

		// "552"
//		String X = "5525";
//		String Y = "1255";

		System.out.println(main.solution(X, Y));
	}

	private String solution(String X, String Y) {
		String answer = "-1";
		
		HashMap<String, Integer> hash = new HashMap<>();
		
		for (int i = 0; i < X.length(); i++) {
			hash.put(X.substring(i, i+1), hash.getOrDefault(X.substring(i, i+1), 0) + 1);
		}
		System.out.println(hash);
		
		int[] number = new int[10];
		for (String key : hash.keySet()) {
			int yCnt = Y.length() - Y.replace(key, "").length();
			number[Integer.parseInt(key)] = Math.min(hash.get(key), yCnt);
		}
		
		System.out.println(Arrays.toString(number));
		
		StringBuilder sb = new StringBuilder();
		for (int i = number.length-1; i >= 0; i--) {
			if(number[i] > 0) {
				for (int j = 0; j < number[i]; j++) {
					sb.append(i);
				}
			}
		}
		
		if(sb.length() > 0) {
			int idx = 0;
			for (int i = 0; i < sb.length(); i++) {
				if(sb.charAt(i) != '0') {
					idx = i;
					break;
				}
				
				if(i == sb.length()-1) {
					idx = sb.length()-1;
				}
			}
			
			answer = sb.toString().substring(idx);
		}
		
		return answer;
	}

}
