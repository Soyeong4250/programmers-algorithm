package lv2;

import java.util.Arrays;
import java.util.Iterator;

public class ExpressionOfNumber { // 수의 표현

	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = 0;
		int[] sum = new int[n];

		sum[0] = 1;
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + (i + 1);
		}

//		System.out.println(Arrays.toString(sum));

		for (int i = 0; i < sum.length; i++) {
			if (sum[i] < 15) {
				continue;
			} else if (sum[i] == 15) {
				answer++;
			} else {
				for (int j = 0; j < i; j++) {
					if (sum[i] - sum[j] == 15) {
//						System.out.println(i + " : " + sum[i] + ", " + j + " : " + sum[j]);
						answer++;
					}
				}
			}
		}
		return answer;
	}

}
