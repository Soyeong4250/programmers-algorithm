package lv3;

import java.util.Arrays;

public class BestSet { // 최고의 집합

	public static void main(String[] args) {
		BestSet main = new BestSet();

//		int n = 2;
//		int s = 9;

//		int n = 2;
//		int s = 1;

//		int n = 2;
//		int s = 8;

		
		int n = 12;
		int s= 13;
		System.out.println(Arrays.toString(main.solution(n, s)));
	}

	private int[] solution(int n, int s) {
		if(s < n) return new int[] {-1};
		
		int[] answer = new int[n];
		
		Arrays.fill(answer, s/n);
		
		for (int i = 0; i < s%n; i++) {
			answer[answer.length-1-i]++;
		}
			
		return answer;
	}

}
