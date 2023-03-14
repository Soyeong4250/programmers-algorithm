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
		
		System.out.println(Arrays.toString(sum));
		
		int answer = 0;
		int checkIdx = 1;
		
		for (int i = 1; i < sum.length; i++) {
			if(sum[i] == n) {
				System.out.println(sum[i]);
				answer++;
			}else if(sum[i] > n) {
				for (int j = checkIdx; j < i; j++) {
					if(sum[i] - sum[j] == n) {
						System.out.println(sum[i]);
						answer++;
					}
				}
			}
		}
		
		return answer;
	}

}
