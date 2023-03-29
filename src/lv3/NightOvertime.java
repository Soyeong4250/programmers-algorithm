package lv3;

import java.util.Collections;
import java.util.PriorityQueue;

public class NightOvertime { // 야근 지수

	public static void main(String[] args) {
		NightOvertime main = new NightOvertime();

//		int[] works = { 4, 3, 3 };
//		int n = 4;

//		int[] works = {2, 1, 2};
//		int n = 1;

		int[] works = {1, 1};
		int n = 3;

		System.out.println(main.solution(n, works));
	}

	private long solution(int n, int[] works) {
		long answer = 0;
		
		PriorityQueue<Integer> time = new PriorityQueue<>(Collections.reverseOrder());
		
		int sum = 0;
		for (int i = 0; i < works.length; i++) {
			System.out.println(works[i]);
			time.add(works[i]);
			sum += works[i];
		}
		
		if(sum <= n) {
			return 0;
		}
		
		while(n > 0 && !time.isEmpty()) {
			int t = time.poll();
			System.out.println(t);
			if(t > 0) {
				t--;
				time.add(t);
				n--;
			}
		}
		
		while(!time.isEmpty()) {
			int t = time.poll();
			System.out.println(t);
			answer += Math.pow(t, 2);
			System.out.println("answer = " + answer);
		}
		
		return answer;
	}

}
