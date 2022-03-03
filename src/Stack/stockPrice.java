package Stack;

import java.util.Arrays;
import java.util.Stack;

public class stockPrice { // 주식가격

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };

		System.out.println(solution(prices));

	}

	private static int[] solution(int[] prices) {
		
		int[] answer = new int[prices.length];  // 인덱스 담는 배열
		Stack<Integer> stack = new Stack();
		
		for (int i = 0; i < prices.length-1; i++) {
			while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
				answer[stack.peek()] = i - stack.peek();  
				stack.pop();
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {  // 가격이 떨어지지 않은 주식
			answer[stack.peek()] = prices.length - stack.peek() - 1;
			stack.pop();
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
		
	}

}
