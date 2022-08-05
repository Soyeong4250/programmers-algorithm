package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StandingLine { // 줄 서는 방법

	public static void main(String[] args) {
//		int n = 3;
//		long k = 5;

		int n = 4;
		long k = 6;
		
		System.out.println(solution(n, k));
	}

	private static int[] solution(int n, long k) {
		int[] answer = new int[n];
		List<Integer> list = new ArrayList<>();  // 숫자를 담을 list
		long factorial = 1;
		
		// 1. n팩토리얼 구하기
		for(int i = 1; i <= n; i++) {
			factorial *= i;
			list.add(i);
		}
		
		int idx = 0;
		
		while(n > 0) {
			factorial /= n;  // 정해지지 않은 자리 중 가장 맨 앞을 제외한 factorial(경우의 수)
			System.out.println(factorial);
			
			int num = 0;
			if(k%factorial == 0) {
				num = (int)(k/factorial) - 1;
			} else {
				num = (int)(k/factorial);
			}

			System.out.println(num);
			System.out.println(list);
			answer[idx] = list.get(num);
			list.remove(num);
			
			k %= factorial;  // 나머지 위치 판단
			idx++;  // 다음 인덱스로 넘어가기
			n--;  // 가장 맨 앞의 수 정해짐
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}

}
