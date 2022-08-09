package lv1;

import java.util.List;
import java.util.ArrayList;

public class DartGame {  // 다트 게임 

	public static void main(String[] args) {
//		String dartResult = "1S2D*3T";
		String dartResult = "1D2S#10S";
//		String dartResult = "1D2S0T";
//		String dartResult = "1S*2T*3S";
//		String dartResult = "1D#2S*3S";
//		String dartResult = "1T2D3D#";
//		String dartResult = "1D2S3T*";
		
		System.out.println(solution(dartResult));
	}

	private static int solution(String dartResult) {
		int answer = 0;
		
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		int cate = -1;  // 0: 숫자, 1: STD. 2: *, #
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dartResult.length(); i++) {
			String ch = dartResult.substring(i, i+1);
			if(ch.matches("[0-9]")) {
				if(cate != 0) {
					list.add(ch);
					cate = 0;
				}				
			} else if(ch.matches("[A-Z]")) {
				if(cate != 1) {
					list.add(ch);
					cate = 0;
				}
			}
		}
		
		return answer;
	}
}
