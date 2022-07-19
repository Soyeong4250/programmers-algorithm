package lv1;

import java.util.List;
import java.util.ArrayList;

public class ReverseNumber {  // 자연수 뒤집어 배열로 만들기

	public static void main(String[] args) {
		long n = 12345;
		
		System.out.println(solution(n));
	}
	
	private static int[] solution(long n) {
		
		List<Integer> list = new ArrayList<>();
		
		while(n > 0) {
			list.add((int) (n%10));
			n /= 10;
		}
		
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}
