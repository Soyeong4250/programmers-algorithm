package SampleQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class KakaoBlindRecruitment4 { // 신고 결과 받기

	public static void main(String[] args) {
//		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
//		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
//		int k = 2;

		String[] id_list = {"con", "ryan"};
		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 3;

		System.out.println(solution(id_list, report, k));
	}

	private static int[] solution(String[] id_list, String[] report, int k) {
		
		int[] answer = new int[id_list.length];
		
		 // 중복값 없애기
		HashSet<String> hashSet = new HashSet<>(); 
		for (String r : report) {
			hashSet.add(r);
		}
		System.out.println(hashSet);
		
		// 각 사람이 신고당한 횟수 구하기
		HashMap<String, ArrayList<String>> reportCnt = new HashMap<>();
		for (String r : hashSet) {
			StringTokenizer st = new StringTokenizer(r);
			String reporter = st.nextToken();
			String target = st.nextToken();
			
			if(reportCnt.containsKey(target)) {
				reportCnt.get(target).add(reporter);  // target를 신고한 사람의 List에 신고자 추가
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(reporter);
				reportCnt.put(target, list);
			}
		}
		
		HashMap<String, Integer> result = new HashMap<>();
		
		for (String key : reportCnt.keySet()) {
			if(reportCnt.get(key).size() >= k) {
				for (String str : reportCnt.get(key)) {
					result.put(str, result.getOrDefault(str, 0) + 1);
				}
			}
		}
		
		System.out.println(result);
		
		for (int i = 0; i < answer.length; i++) {
			if(!result.containsKey(id_list[i])) {
				answer[i] = 0;
			}else {
				answer[i] = result.get(id_list[i]);
			}
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
