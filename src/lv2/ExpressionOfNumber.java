package lv2;

import java.util.Arrays;

public class ExpressionOfNumber { // 수의 표현

	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int[] sum = new int[n+1];
		
		sum[0] = 0;
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i-1] + i;
		}
		
		int startIdx = 1;
		int endIdx = 0;
		int answer = 0;
		
		while(startIdx <= n && endIdx <= n) {
			int result = sum[startIdx] - sum[endIdx];
			
			if(result < n) {
				startIdx++;
			}else if(result == n) {
				answer++;
				startIdx++;
			}else {
				endIdx++;
			}
		}
		
		return answer;
	}

}
