package lv3;

import java.util.ArrayList;
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
		// -1 판별
		for (int i = 0; i < scores.length-1; i++) {
			for (int j = i+1; j < scores.length; j++) {
				if(scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]) {
					scores[i][0] = -1;
					scores[i][1] = -1;
					
					if(i == 0) {
						return -1;
					}
				}
			}
		}
		
		int wanho = scores[0][0] + scores[0][1];
		int[] sum = new int[scores.length];
		for (int i = 1; i < scores.length; i++) {
			sum[i] = scores[i][0] + scores[i][1];
		}
		Arrays.sort(sum);
		int grade = 1;
		for (int i = sum.length-1; i >= 0; i--) {
			if(sum[i] > wanho) {
				grade++;
			}else if(sum[i] == wanho) {
				break;
			}
		}
		
		return grade;
	}

}
