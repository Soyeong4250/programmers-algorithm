package lv1;

import java.util.Arrays;

public class gymClothes { // 체육복

	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 1, 3, 5 };
//		int n=5;
//		int[] lost = {2, 4};
//		int[] reserve = {3};
//		int n=3;
//		int[] lost = {3};
//		int[] reserve = {1};

		System.out.println(solution(n, lost, reserve));
	}
	
	static int cnt = 0;
	private static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		
		int[] student = new int[n+1];  // 각 학생들이 갖고 있는 체육복의 수
		Arrays.fill(student, 1);
		
		for (int i = 0; i < reserve.length; i++) {
			student[reserve[i]]++;
		}
		for (int i = 0; i < lost.length; i++) {
			student[lost[i]]--;
		}
		
		System.out.println(Arrays.toString(student));
		
		dfs(student, 1);
		return answer;
	}
	
	private static void dfs(int[] student, int idx) {
		if(idx == student.length) {
			return;
		}
		
		for (int i = idx; i < student.length; i++) {
			if(1 < idx && idx < student.length && student[idx] == 0) {
				if(student[idx-1] >= 2) {
					student[idx-1]--;
					student[idx+1]++;
					dfs()
				}
			}
		}
	}

}
