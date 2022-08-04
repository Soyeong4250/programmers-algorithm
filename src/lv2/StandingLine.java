package lv2;

import java.util.ArrayList;
import java.util.List;

public class StandingLine { // 줄 서는 방법

	public static void main(String[] args) {
		int n = 3;
		long k = 5;

		System.out.println(solution(n, k));
	}

	private static int[] solution(int n, long k) {
		int[] answer = new int[n];
		List<String> list = new ArrayList<>();
		int factorial = 1;
		
		// 1. n팩토리얼 구하기
		for(int i = 1; i <= n; i++) {
			factorial *= i;
		}
		
		long cnt = k; 
		while()
		
	}

}
