package lv1;

import java.util.Arrays;

public class LottoMaxrankMinrank { // 로또의 최고 순위와 최저 순위

	public static void main(String[] args) {
//		int[] lottos = { 44, 1, 0, 0, 31, 25 };
//		int[] win_nums = { 31, 10, 45, 1, 6, 19 };
//		int[] lottos = {0, 0, 0, 0, 0, 0};
//		int[] win_nums = {38, 19, 20, 40, 15, 25};
		int[] lottos = {45, 4, 35, 20, 3, 9};
		int[] win_nums = {20, 9, 3, 45, 4, 35};

		System.out.println(solution(lottos, win_nums));
	}

	private static int[] solution(int[] lottos, int[] win_nums) {
		Arrays.sort(lottos);
		Arrays.sort(win_nums);
		
		int zero = 0;
		int win = 0;
		for(int i=0; i<lottos.length; i++) {
			if(lottos[i] == 0) {
				zero++;
				continue;
			}
			
			for(int j=0; j<win_nums.length; j++) {
				if(lottos[i] == win_nums[j]) {
					win++;
					break;
				}
			}
		}
		
//		System.out.println(zero);  // 0의 개수
//		System.out.println(win);  // 맞은 숫자의 개수
		
		int[] answer = new int[2];
		// 최대 순위일 때 맞은 개수
		answer[0] = win+zero;
		// 최저 순위일때 맞은 개수
		answer[1] = win;
		
		// 맞은 개수를 순위로 바꾸기
		for(int i=0; i<answer.length; i++) {
//			System.out.println(answer[i]);
			answer[i] = 7 - answer[i];
			if(answer[i] == 7) {  // 한 개도 못맞은 경우
				answer[i] = 6;
			}
		}
//		System.out.println(Arrays.toString(answer));
		return answer;
	}

}
