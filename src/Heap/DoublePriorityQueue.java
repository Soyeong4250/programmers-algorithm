package Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DoublePriorityQueue {

	public static void main(String[] args) {
//		String[] operations = {"I 16", "D 1"};
//		String[] operations = {"I 7","I 5","I -5","D -1"};
//		String[] operations = {"I 1", "I 2", "I 3", "D -1", "D -1", "I -1", "I -2", "I -3", "D 1"};
//		String[] operations = {"I 10", "I 20", "D 1", "I 30", "I 40", "D -1", "D -1"};
		String[] operations = {"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"};
		
		System.out.println(solution(operations));
	}

	private static int[] solution(String[] operations) {
		int[] answer = new int[2];
		
		PriorityQueue<Integer> minq = new PriorityQueue<>();  // 낮은 숫자가 우선 순위
		PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());  // 높은 숫자가 우선 순위
		
		for (int i = 0; i < operations.length; i++) {
			StringTokenizer st = new StringTokenizer(operations[i]);
			String command = st.nextToken();
			int number = Integer.parseInt(st.nextToken());
			
			if(command.equals("I")) {
				minq.offer(number);
				maxq.offer(number);
			}else {  // q.poll() 첫번째 값을 반환하고 제거 & 비어있다면 null = q.peek() 우선순위가 가장 높은 값을 참조 & 제거하지 않음
				if(!minq.isEmpty() && number == -1) { 
					int delete = minq.poll();
					maxq.remove(delete);
//					System.out.println("최소힙 우선순위큐에서 삭제된 숫자는 " + delete);
				}else if(!maxq.isEmpty() && number == 1) {
					int delete = maxq.poll();
					minq.remove(delete);
//					System.out.println("최대힙 우선순위큐에서 삭제된 숫자는 " + delete);
				}
			}
			// 확인
//			System.out.println(minq);
//			System.out.println(maxq);
		}
		
		if(minq.isEmpty()) {
			Arrays.fill(answer, 0);
		}else {
			answer[0] = maxq.poll();
			answer[1] = minq.poll();
		}
		
		// 확인
		System.out.println(Arrays.toString(answer));
		
		return answer;
	}
}
