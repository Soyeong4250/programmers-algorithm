package lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PerformanceAssessment { // 인사고과

	public static void main(String[] args) {
		PerformanceAssessment main = new PerformanceAssessment();

//		int[][] scores = { { 2, 2 }, { 1, 4 }, { 3, 2 }, { 3, 2 }, { 2, 1 }};
		int[][] scores = {{1, 1}, {5, 3}, {2, 4}, {1, 4}};
//		int[][] scores = {{2, 2}, {2, 2}, {3, 2}, {2, 3}};
		System.out.println(main.solution(scores));
	}

	private int solution(int[][] scores) {
		int wanhoScore = scores[0][0] + scores[0][1];
		
		HashMap<Integer, Integer> scoreHash = new HashMap<>();
		
		for (int i = 1; i < scores.length; i++) {
			if(scores[0][0] < scores[i][0] && scores[0][1] < scores[i][1]) {
				return -1;
			}
			
			int sum = scores[i][0] + scores[i][1];
			scoreHash.put(sum, scoreHash.getOrDefault(sum, 0) + 1);
		}
		
		List<Integer> keyList = new ArrayList<>(scoreHash.keySet());
		keyList.sort((s1, s2) -> s2-s1);
		
		System.out.println(keyList);
		
		int grade = 0;
		for (int key : keyList) {
			if(key == wanhoScore) {
				grade += 1;
				break;
			}else {
				grade += scoreHash.get(key);
			}
		}
		
		return grade;
	}

}
