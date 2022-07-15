package lv1;

import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Budget { // 예산

	public static void main(String[] args) {
		int[] d = {1, 3, 2, 5, 4};
		int budget = 9;
//		int[] d = {2, 2, 3, 3};
//		int budget = 10;
		
		System.out.println(solution(d, budget));
	}

	private static int solution(int[] d, int budget) {
		int answer = 0;
		
		Arrays.sort(d);
		System.out.println(Arrays.toString(d));
		
		for (int i = 0; i < d.length; i++) {
			if(budget-d[i] < 0) break;
			budget -= d[i];
			answer++;
		}
		
		return answer;
	}

}
