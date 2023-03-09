package lv3;

import java.util.Arrays;

public class PerformanceAssessment { // 인사고과

	public static void main(String[] args) {
		PerformanceAssessment main = new PerformanceAssessment();

//		int[][] scores = { { 2, 2 }, { 1, 4 }, { 3, 2 }, { 3, 2 }, { 2, 1 }};
//		int[][] scores = {{1, 1}, {5, 3}, {2, 4}, {1, 4}};
		int[][] scores = {{2, 2}, {2, 2}, {3, 2}, {2, 3}};
		System.out.println(main.solution(scores));
	}

	private int solution(int[][] scores) {
		int wanhoScore = scores[0][0] + scores[0][1];
		
		int[] sum = new int[scores.length];
		int min1 = 100001;
		int min2 = 100001;
		
		for (int i = 0; i < sum.length; i++) {
			sum[i] = scores[i][0] + scores[i][1];
			if(scores[0][0] < scores[i][0] && scores[0][1] < scores[i][1]) {
				return -1;
			}
		}
		
		if(scores[0][0] == min1 && scores[0][1] == min2) {
			return -1;
		}
		
		Arrays.sort(sum);
		System.out.println(Arrays.toString(sum));
		
		int prev = sum[0];
		int grade = 1;
		for (int i = sum.length-1; i >= 0; i--) {
			if(sum[i] == wanhoScore) {
				break;
			}
			if(prev == sum[i]) {
				grade++;
			} else {
				prev = sum[i];
				grade++;
			}
		}
		
		return grade;
	}

}
