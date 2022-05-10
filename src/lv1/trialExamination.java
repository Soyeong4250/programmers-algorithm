package lv1;

import java.util.ArrayList;
import java.util.List;

public class trialExamination { // 모의고사

	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };
//		int[] answers = { 1, 3, 2, 4, 2 };

		System.out.println(solution(answers));
	}

	private static int[] solution(int[] answers) {
		int[] answer = {};
		
		int[] one = {1, 2, 3, 4, 5};
		int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		List<Integer> list = new ArrayList<>();
		int[] max = new int[3];
		for (int i = 0; i < answers.length; i++) {
			if(answers.length <= one.length) {
				
			}
		}
		
		
		return null;
	}

}
