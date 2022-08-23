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
		
		System.out.println(solution(queue1, queue2));
	}

	private static int solution(int[] queue1, int[] queue2) {
		int result = 0;
		
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		long sum = 0;
		long q1Sum = 0;
		long q2Sum = 0;
		for(int i=0; i<queue1.length; i++) {
			sum += queue1[i];
			q1Sum += queue1[i];
			q1.add(queue1[i]);
		}
		for(int i=0; i<queue2.length; i++) {
			sum += queue2[i];
			q2Sum += queue2[i];
			q2.add(queue2[i]);
		}
		
		while(true) {
			if(q1Sum == sum/2 && q2Sum == sum/2) {
				break;
			}
			
			if(result >= q1.size()) {
				result = -1;
				break;
			}
			
			int a = q1.poll();
			int b = q2.poll();
			q1.add(b);
			q2.add(a);
			q1Sum += b;
			q1Sum -= a;
			q2Sum += a;
			q2Sum -= b;
			result++;
			System.out.println(q1Sum + ", " + q2Sum);
		}
		
		return result;
	}

}
