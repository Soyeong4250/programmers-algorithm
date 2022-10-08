package lv3;

import java.util.Arrays;

public class TravelRoute { // 여행 경로

	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

		System.out.println(solution(tickets));

	}

	static String answer = "";
	private static String[] solution(String[][] tickets) {
		
		// 1. 항공권 체크 배열
		boolean [] v= new boolean[tickets.length];
		
		// 2. 경로 탐색
		dfs(tickets, v, "ICN", "ICN", 0);
		
		System.out.println(Arrays.toString(answer.split(",")));
		return answer.split(",");
	}

	private static void dfs(String[][] tickets, boolean[] v, String path, String dep, int cnt) {
		
		// 3. 기저조건 설정
		if(cnt == v.length) {  // 모두 선택
//			System.out.println(path);
			if (answer.length() == 0) {
				answer = path;
//				System.out.println("시작 answer : " + answer);				
			}else if(answer.compareTo(path) > 0) {
				answer = path;
//				System.out.println("변경된 answer : " + answer);
			}
			return;
		}
		
		// 4. 배열을 순회
		for (int i = 0; i < v.length; i++) {
			if(tickets[i][0].equals(dep) && !v[i]) {
				v[i] = true;
				dfs(tickets, v, path + "," + tickets[i][1], tickets[i][1], cnt+1);
				v[i] = false;
			}
		}
	}
}
