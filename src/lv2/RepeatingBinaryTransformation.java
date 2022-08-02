package lv2;

import java.util.Arrays;

public class RepeatingBinaryTransformation {  // 이진 변환 반복하기

	public static void main(String[] args) {
//		String s = "110010101001";
//		String s = "01110";
		String s = "1111111";
		
		System.out.println(solution(s));
	}
	
	private static int[] solution(String s) {
		int[] answer = new int[2];  // [이진변환횟수, 제거된 모든 0의 개수]
		
		while(!s.equals("1")) {
			// 1. 0 제거하기 & 0 개수세기
			int x = s.length();  // 원래 s길이
			s = s.replaceAll("[^1-9]", "");  // 0 모두 제거
			answer[1] += x - s.length(); // 제거된 0의 개수 = 원래 길이 - 0을 제거한 문자열 길이
			
			// 2. 이진변환하기
			s = Integer.toBinaryString(s.length());  // 0을 제거한 x의 길이
			answer[0]++;  // 이진변환횟수 + 1;
		}
		
//		System.out.println(Arrays.toString(answer));
		
		return answer;
	}

}
