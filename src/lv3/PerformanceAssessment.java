package lv3;

import java.util.Arrays;
import java.util.Comparator;

public class PerformanceAssessment { // 인사고과

	public static void main(String[] args) {
		PerformanceAssessment main = new PerformanceAssessment();

//		int[][] scores = { { 2, 2 }, { 1, 4 }, { 3, 2 }, { 3, 2 }, { 2, 1 }};  // 4
		int[][] scores = {{1, 1}, {5, 3}, {2, 4}, {1, 4}};  // -1
//		int[][] scores = {{3, 2}, {2, 4}, {0, 1}, {1, 4}, {3, 6}};  // 2
//		int[][] scores = {{2, 2}, {2, 2}, {3, 2}, {2, 3}};  // 3
		System.out.println(main.solution(scores));
	}

	private int solution(int[][] scores) {
		int[] wanhoScore = scores[0];
//		System.out.println(Arrays.toString(wanhoScore));
		
		Arrays.sort(scores, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				
				return o2[0] - o1[0];
			}
		});
		
//		for (int i = 0; i < scores.length; i++) {
//			System.out.println(Arrays.toString(scores[i]));			
//		}
		
		int wanhoSum = wanhoScore[0] + wanhoScore[1];
		int peerScore = 0;
		int grade = 1;
		for (int i = 0; i < scores.length; i++) {
			if(scores[i][1] < peerScore) {
				if(wanhoScore[0] == scores[i][0] && wanhoScore[1] == scores[i][1]) {
					return -1;
				}
			}else {
				peerScore = Math.max(scores[i][1], peerScore);
				if(wanhoSum < scores[i][0] + scores[i][1]) {
					grade++;
				}
			}
		}
		
		return grade;
	}

}
