package lv1;

import java.util.Stack;

public class SameNumber {  // 같은 숫자는 싫어

	public static void main(String[] args) {
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
//		int[] arr = {4, 4, 4, 3, 3};
		
		System.out.println(solution(arr));
	}
	
	private static int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<arr.length; i++) {
			if(!stack.isEmpty() && stack.peek() == arr[i]){
				continue;
			}
			stack.add(arr[i]);
		}
		
		int[] answer = new int[stack.size()];
		for(int i=stack.size()-1; i>= 0; i--) {
			answer[i] = stack.pop();
		}
		
		return answer;
	}

}
