package lv1;

import java.util.Arrays;

public class TrainingClothes { // 체육복

	public static void main(String[] args) {
//		int n = 5;
//		int[] lost = { 2, 4 };
//		int[] reserve = { 1, 3, 5 };
//		int n=5;
//		int[] lost = {2, 4};
//		int[] reserve = {3};
		int n=3;
		int[] lost = {3};
		int[] reserve = {1};

		System.out.println(solution(n, lost, reserve));
	}
	
	private static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		
		int[] student = new int[n+1];  // 학생의 번호는 1번부터 시작
		Arrays.fill(student, 1);
		
		// 잃어버린 학생 체크
		for (int i = 0; i < lost.length; i++) {
			student[lost[i]]--;
		}
		
		// 여분의 학생 체크
		for (int i = 0; i < reserve.length; i++) {
			student[reserve[i]]++;
		}
		
		for (int i = 1; i < student.length; i++) {
			if(student[i] == 0) {
				if(1 < i && student[i-1] == 2) {
					student[i-1]--;
					student[i]++;
				} else if (i < n && student[i+1] == 2) {
					student[i+1]--;
					student[i]++;
				}
			}
		}
		
//		System.out.println(Arrays.toString(student));
		
		for (int i = 1; i < student.length; i++) {
			if(0 < student[i]) {
				answer++;
			}
		}
		
		return answer;
	}

}
