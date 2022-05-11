package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class trialExamination { // 모의고사

	public static void main(String[] args) {
//		int[] answers = { 1, 2, 3, 4, 5 };
		int[] answers = { 1, 3, 2, 4, 2 };

		System.out.println(solution(answers));
	}

	private static int[] solution(int[] answers) {
		int[] one = {1, 2, 3, 4, 5};
		int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		ArrayList<Integer> list = new ArrayList<>();
		int[] success = new int[3];
		for (int i = 0; i < answers.length; i++) {
			if(answers[i] == one[i%one.length]) {
				success[0]++;
			}
			if(answers[i] == two[i%two.length]) {
				success[1]++;
			}
			if(answers[i] == three[i%three.length]) {
				success[2]++;
			}
		}
		
		int max = 0;
		for (int i = 0; i < success.length; i++) {
			if(max < success[i]) max = success[i];
		}
		
		for (int i = 0; i < success.length; i++) {
			if(success[i]  == max) {
				list.add(i);
			}
		}
		
		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i)+1;
		}
		
//		System.out.println(Arrays.toString(answer));
		return answer;
	}

}
