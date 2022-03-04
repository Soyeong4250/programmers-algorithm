package SampleQuestions;

import java.util.Stack;

public class Pair { // 2017 팀스타운 - 짝지어 제거하기

	public static void main(String[] args) {
		String s = "baabaa";
		// String s = "cdcd";
		
		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int answer = 0;
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++){
			if(stack.isEmpty()) {  // 스택이 비어있는 경우
				stack.add(s.charAt(i));
			}else {  // 스택이 비어있지 않은 경우
				if(stack.peek() == s.charAt(i)) {
					stack.pop();  // 제거
				} else {
					stack.add(s.charAt(i));
				}
			}
		}
		
		if(stack.isEmpty()) {
			answer = 1;
		}else {
			answer = 0;
		}
		
		return answer;
	}

}
