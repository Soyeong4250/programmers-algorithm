package lv2;

import java.util.Stack;

public class ChangeBracket { // 괄호 변환

	public static void main(String[] args) {
		String p = "(()())()";
//		String p = ")(";
//		String p = "()))((()";

		System.out.println(solution(p));
	}

	private static String solution(String p) {
		String answer = p;
		
		if(balance(answer)) {
			return answer;
		}
		
		return answer;
	}

	private static boolean balance(String answer) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < answer.length()-1; i++) {
			String str = answer.substring(i, i+1);
			
			if(!stack.isEmpty() && !stack.peek().equals(str)) {
				stack.pop();
			}else {
				stack.add(str);
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		
		return false;
	}

}
