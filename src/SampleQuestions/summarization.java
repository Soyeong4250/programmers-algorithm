package SampleQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class summarization { // 2020 카카오 블라인드 - 문자열 압축 -> 다시 풀기

	public static void main(String[] args) {
		String s = "aabbaccc";

		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int zip = s.length()/2;  // 압축된 문자 길이
		
		char[] arr = new char[zip];
		StringBuilder sb = new StringBuilder();
		while(true) {
			
			for (int i = 0; i < zip; i++) {
				arr[i] = s.charAt(i);
			}
			
			for (int i = zip; i < zip+zip; i++) {
				if(arr[i-zip] != s.charAt(i)) {
					zip -= 1;
					break;
				}
			}
			
			sb.append("2");
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			
			
			
			
		}
				
		
		return answer;
	}

}
