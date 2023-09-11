package lv2;

import java.util.Arrays;
import java.util.Iterator;

public class Hopscotch { // 땅따먹기

	public static void main(String[] args) {
		Hopscotch main = new Hopscotch();

		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };

		System.out.println(main.solution(land));
	}

	private int solution(int[][] land) {
		int answer = 0;
		int[][] dp = new int[land.length][land[0].length];
		
		for (int i = 0; i < land.length; i++) {
			if(i == 0) {
				for (int j = 0; j < land[i].length; j++) {
					dp[i][j] = land[i][j];
				}
			} else {
				for (int j = 0; j < land[i].length; j++) {
					for (int k = 0; k < dp.length; k++) {
						if(j == k) continue;
						dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
					}
				}
			}
			print(dp);
			System.out.println("-------------");
		}
		
		for (int i = 0; i < dp.length; i++) {
			answer = Math.max(answer, dp[land.length-1][i]);
		}
		
		return answer;
	}

	private void print(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}

}
