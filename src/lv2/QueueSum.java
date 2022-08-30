package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSum {  // 두 큐 합 같게 먼둘기

	public static void main(String[] args) {
//		int[] queue1 = {3, 2, 7, 2};
//		int[] queue2 = {4, 6, 5, 1};
		
//		int[] queue1 = {1, 2, 1, 2};
//		int[] queue2 = {1, 10, 1, 2};
		
		int[] queue1 = {1, 1};
		int[] queue2 = {1, 5};
		
//		int[] queue1 = {1, 1, 1, 1, 1};
//		int[] queue2 = {1, 1, 1, 9, 1};
		// result : 12

		System.out.println(solution(queue1, queue2));
	}

	private static int solution(int[] queue1, int[] queue2) {
		int result = 0;
		
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		
		long sum = 0;
		long sum1 = 0;
		long sum2 = 0;
		
		for (int i = 0; i < queue2.length; i++) {
			q1.add(queue1[i]);
			sum += queue1[i];
			sum1 += queue1[i];			
			
			q2.add(queue2[i]);
			sum += queue2[i];
			sum2 += queue2[i];
		}
		
		long half = sum/2;
		boolean same = true;
		
		while(sum1 != half || sum2 != half) {
			if(result > queue1.length*3) {
				same = false;
				break;
			}
			
			if(!q1.isEmpty() && sum1 > sum2) { // sum1이 sum2보다 크다면
				int num = q1.poll();
				q2.add(num);
				sum1 -= num;
				sum2 += num;
			} else if(!q2.isEmpty() && sum1 < sum2){  // sum2가 sum1보다 크다면
				int num = q2.poll();
				q1.add(num);
				sum2 -= num;
				sum1 += num;	
			}
			result++;
			System.out.println(q1);
			System.out.println(q2);
			System.out.println(result);
			System.out.println("sum1 : " + sum1 + "sum2 : " + sum2);
		}
		
		if(!same) {
			result = -1;
		}
			
		return result;
	}

}
