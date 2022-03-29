package SampleQuestions;

import java.util.Arrays;
import java.util.HashSet;

public class KakaoBlindRecruitment4 { // 신고 결과 받기

	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;

//		String[] id_list = {"con", "ryan"};
//		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//		int k = 3;

		System.out.println(solution(id_list, report, k));
	}

	private static int[] solution(String[] id_list, String[] report, int k) {
		
		int[] answer = {};
		
		 // 중복값 없애기
		HashSet<String> hashSet = new HashSet<>(Arrays.asList(id_list)); 
		String[] id = hashSet.toArray(new String[0]);
		
		System.out.println(Arrays.toString(id));
		
		return answer;
	}
}
