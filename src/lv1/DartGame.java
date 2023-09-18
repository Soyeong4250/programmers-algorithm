package lv1;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class DartGame {  // 다트 게임 

	public static void main(String[] args) {
		
		// (1¹ * + 2³) * 2 + 3³		
		String dartResult = "1S2D*3T";
		
		// 1² + 2¹ * (-1) + 10¹
//		String dartResult = "1D2S#10S";
		
		// 1² + 2¹ + 0³
//		String dartResult = "1D2S0T";
		
		// (1¹ * 2 + 2³ * 2) * 2 + 3¹
//		String dartResult = "1S*2T*3S";
//		String dartResult = "1D#2S*3S";
//		String dartResult = "1T2D3D#";
//		String dartResult = "1D2S3T*";
		
		System.out.println(solution(dartResult));
	}

	private static int solution(String dartResult) {
		int answer = 0;
		
		int sum = 0;
		double number = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dartResult.length(); i++) {
			char ch = dartResult.charAt(i);
			
			if(Character.isDigit(ch)) {
				sum += number;
				number = 0;
				System.out.println("isNumber");
				sb.append(ch);
			} else if('A' <= ch && ch <= 'Z') {
				if(!sb.isEmpty()) {
					number = Integer.parseInt(sb.toString());
					sb.setLength(0);  // 초기화
					
					switch(ch) {
					case 'D' : 
						number = Math.pow(number, 2);
						break;
					case 'T' : 
						number = Math.pow(number, 3);
						break;
					}
				}
			} else if (ch == '*') {
				sum += number;
				sum *= 2;
			} else if (ch == '#') {
				number *= (-1);
				sum += number;
			}
			System.out.println("ch = " + ch + ", sum = " + sum);
		}
		
		
		return sum;
	}
}
