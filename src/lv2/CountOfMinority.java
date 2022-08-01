package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfMinority { // k진수에서 소수 개수 구하기
	
	public static void main(String[] args) {
//		int n = 437674;
//		int k = 3;
//		int n = 110011;
//		int n = 110000001;
//		int k = 10;
		int n = 25;
		int k = 2;
		
		System.out.println(solution(n, k));
	}
	
	private static int solution(int n, int k) {
		int answer = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while (n > 0) {
			sb.append(n % k);
			n /= k;
		}
		
		System.out.println(sb.toString());
		
		List<String> numList = Arrays.asList(sb.reverse().toString().split("0"));
		System.out.println(numList);
		
		for(String num:numList) {
			if(num.equals("")) {
				continue;
			}
			if(isMinority(Long.parseLong(num))) {
				answer++;
			}
		}
		
		return answer;
	}
	
	private static boolean isMinority(long num) {
		if(num == 1) {
			return false;
		}
		
		for(int i=2; i <= Math.sqrt(num); i++) {
			if(num%i==0) {
				System.out.println(num + "은 " + i + " 때문에 소수 아님");
				return false;
			}
		}
		return true;
	}
	
}
