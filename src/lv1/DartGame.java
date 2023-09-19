package lv1;

import java.util.Arrays;

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

		int[] sum = new int[3];
		int idx = 0;  // sum 인덱스

		StringBuilder number = new StringBuilder();
		for (int i = 0; i < dartResult.length(); i++) {
			char ch = dartResult.charAt(i);
			if(Character.isLetter(ch) && Character.isUpperCase(ch)) {
				if(ch == 'S') {
					sum[idx] = Integer.parseInt(number.toString());
				} else if (ch == 'D') {
					sum[idx] = (int)Math.pow(Integer.parseInt(number.toString()), 2);
				} else if (ch == 'T') {
					sum[idx] = (int)Math.pow(Integer.parseInt(number.toString()), 3);
				}
				number.setLength(0);
				idx += 1;
			} else if(ch == '*') {
				if(idx >= 2) {
					for (int j=idx-2; j<idx; j++) {
						sum[j] *= 2;
					}
				} else {
					for (int j = 0; j<idx; j++) {
						sum[j] *= 2;
					}
				}
			} else if(ch == '#') {
				sum[idx-1] *= -1;
			} else {
				number.append(ch);
			}

			System.out.println("number = " + number);
			System.out.println("sum = " + Arrays.toString(sum));
		}

		for (int i = 0; i < sum.length; i++) {
			answer += sum[i];
		}

		return answer;
	}
}
