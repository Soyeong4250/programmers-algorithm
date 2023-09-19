package lv1;

import java.util.Arrays;
import java.util.Comparator;

public class FailureRate { // 실패율

	public static void main(String[] args) {
		FailureRate main = new FailureRate();

		// [3, 4, 2, 1, 5]
		int N = 5; // 전체 스테이지의 개수
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 }; // 게임을 이용하는 사용자가 현재 멈춰있는 스테이지 번호 배열

		// [4, 4, 4, 4, 4]
//		int N = 4;  // 전체 스테이지의 개수
//		int[] stages = {4, 4, 4, 4, 4};  // 게임을 이용하는 사용자가 현재 멈춰있는 스테이지 번호 배열

		System.out.println(Arrays.toString(main.solution(N, stages)));
	}

	private int[] solution(int N, int[] stages) {
		int[] answer = new int[N];

		int people = stages.length;
		double[][] memo = new double[N][2];

		for (int i = 0; i < stages.length; i++) {
			if (stages[i] > N) {
				continue;
			}

			if (memo[stages[i]-1][1] == 0) {
				memo[stages[i]-1][1] = stages[i];
			}
			memo[stages[i]-1][0] += 1;

			print(memo);
		}

		for (int i = 0; i < memo.length; i++) {
			double now = memo[i][0];
			memo[i][0] = memo[i][0] / people;
			people -= now;

			if(people <= 0) break;
		}

		Arrays.sort(memo, (o1, o2) -> {
			System.out.println("o1[0] = " + o1[0] + ", o2[0] = " + o2[0]);
			if(o1[0] == o2[0]) {
				System.out.println("두번째 값 비교");
				return (int)(o1[1] - o2[1]);
			}
			return Double.compare(o2[0], o1[0]);
		});

		for (int i = 0; i < answer.length; i++) {
			answer[i] = (int)memo[i][1];
		}

		return answer;
	}

	private void print(double[][] memo) {
		for (int i = 0; i <memo.length ; i++) {
			System.out.println(Arrays.toString(memo[i]));
		}
	}


}
