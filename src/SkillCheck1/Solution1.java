package SkillCheck1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

	public static void main(String[] args) {
//		int x = 2;
//		int n = 5;
//		int x = 4;
//		int n = 3;
		int x = -4;
		int n = 2;
		
		System.out.println(solution(x, n));
	}

	private static long[] solution(int x, int n) {		
		List<Long> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(x + (long)x*i);
		}
		
		long[] answer = new long[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}

}
