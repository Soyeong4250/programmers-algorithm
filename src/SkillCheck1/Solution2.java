package SkillCheck1;

public class Solution2 {

	public static void main(String[] args) {
//		int a = 5;
//		int b = 24;
		int a = 5;
		int b = 25;
		
		
		System.out.println(solution(a, b));
	}

	private static String solution(int a, int b) {
		String[] week = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
		int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int total = 1;
		for (int i = 0; i < a-1; i++) {
			total += day[i];
		}
		total += b;
		
		String answer = week[total%7];
		
		return answer;
	}

}
