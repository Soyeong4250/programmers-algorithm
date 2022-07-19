package lv1;

import java.util.Arrays;
import java.util.Collections;

public class StringDescendingOrder {  // 문자열 내림차순으로 배치하기

	public static void main(String[] args) {
		String s = "Zbcdefg";
		
		System.out.println(solution(s));
	}
	
	private static String solution(String s) {
		String[] alphabet = s.split("");
		
//		Arrays.sort(alphabet, new Comparator<String>() {
//			
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.compareTo(o2);
//			}
//		});
		
		Arrays.sort(alphabet, Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < alphabet.length; i++) {
			sb.append(alphabet[i]);
		}
		
		return sb.toString();
	}

}
