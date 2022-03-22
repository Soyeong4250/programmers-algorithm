package SampleQuestions;

import java.util.Arrays;
import java.util.HashMap;

public class KakaoBlindRecruitment2 { // 메뉴 리뉴얼

	static HashMap<String, Integer> map = new HashMap<>();  // 각 조합의 개수를 파악할 hashmap
	public static void main(String[] args) {
		// String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = { 2, 3, 4 };

		solution(orders, course);
	}

	private static void solution(String[] orders, int[] course) {
		
		// 1. 정렬하기
		for (int i = 0; i < orders.length; i++) {
			char[] ch = orders[i].toCharArray();
			Arrays.sort(ch);
			// 확인
			// System.out.println(Arrays.toString(ch));
			orders[i] = new String(ch);  // 정렬해서 문자열로 다시 삽입
		}
		
		// 2. 조합 뽑아내기
		for (int i = 0; i < course.length; i++) {
			for (int j = 0; j < orders.length; j++) {
				System.out.println();
				Combination("", orders[j], course[i]);  // j번째 문자열에서 course 길이만큼 조합 뽑기
			}
		}
	}

	private static void Combination(String str, String order, int cnt) {
		// 기저조건
		if(cnt == 0) {  // 다 골랐다
			System.out.println("다 골랐습니다");
			System.out.println(str);
			map.put(str, map.getOrDefault(str, 0) + 1);  // hashmap에 조합 개수 + 1
			return;
		}
		
		for (int i = 0; i < order.length(); i++) {
			System.out.println(order.charAt(i));
			Combination(str + order.charAt(i), order.substring(i+1), cnt-1); 
		}
		
	}



}
