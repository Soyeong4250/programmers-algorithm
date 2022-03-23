package SampleQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class KakaoBlindRecruitment2 { // 메뉴 리뉴얼

	static HashMap<String, Integer> map = new HashMap<>();  // 각 조합의 개수를 파악할 hashmap
	public static void main(String[] args) {
		// String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		// String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = { 2, 3, 4 };

		System.out.println(Arrays.toString(solution(orders, course)));
	}

	private static String[] solution(String[] orders, int[] course) {
		
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
				Combination("", orders[j], course[i]);  // j번째 문자열에서 course 길이만큼 조합 뽑기
			}
		}
		
		// 확인
		// System.out.println(map);
		
		// 3. Entry를 이용한 hash 정렬
		List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(map.entrySet());
		
		// 비교함수 Comparator를 이용하여 오름차순으로 정렬
		Collections.sort(entryList, new Comparator<Entry<String, Integer>>(){

			// compare로 값을 비교
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// 오름차순 정렬
				return o2.getValue().compareTo(o1.getValue());
			}	
		});
		
		// 확인
		// System.out.println(entryList);
		
		// 정답 담기
		List<String> answerList = new ArrayList<>();
		for (int i = 0; i < course.length; i++) {
			int max = 0;
			for (int j = 0; j < entryList.size(); j++) {
				if(course[i] == entryList.get(j).getKey().length()) {  // 정해진 코스의 수와 키의 길이가 같다면 {2, 3, 4}
					if(entryList.get(j).getValue() == 1) {  // 1이면 멈추기
						break;
					} else if(max == 0 || max == entryList.get(j).getValue()) {  // 처음이거나 많이 나온 횟수가 같다면
						answerList.add(entryList.get(j).getKey());  // 정답list에 추가
						max = entryList.get(j).getValue();
					}else if(max > entryList.get(j).getValue()){
						break;
					}
				}
			}
		}
		
		Collections.sort(answerList);
		String[] answer = new String[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
		// System.out.println(answer);
		return answer;
	}

	private static void Combination(String str, String order, int cnt) {
		// 기저조건
		if(cnt == 0) {  // 다 골랐다
//			System.out.println("다 골랐습니다");
//			System.out.println(str);
			map.put(str, map.getOrDefault(str, 0) + 1);  // hashmap에 조합 개수 + 1
			return;
		}
		
		for (int i = 0; i < order.length(); i++) {
//			System.out.println(order.charAt(i));
			Combination(str + order.charAt(i), order.substring(i+1), cnt-1); 
		}
		
	}

}
