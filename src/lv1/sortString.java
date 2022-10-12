package lv1;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class SortString {  // 문자열 내 마음대로 정렬하기

	public static void main(String[] args) {
//		String[] strings = {"sun", "bed", "car"};
//		int n = 1;
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 2;
		
		System.out.println(solution(strings, n));
	}
	
	private static String[] solution(String[] strings, int n) {
		List<String> list = new ArrayList<>(Arrays.asList(strings));
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(n) == o2.charAt(n)) {
					return o1.compareTo(o2);
				}
				
				return o1.charAt(n) - o2.charAt(n);
			}
		});
		
		String[] answer = list.toArray(new String[list.size()]);
		
		return answer;
	}

}
