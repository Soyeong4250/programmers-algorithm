package lv2;

import java.util.Stack;

public class RotateBracket { // 괄호 회전하기

	public static void main(String[] args) {
		RotateBracket main = new RotateBracket();

//		String s = "[](){}";
//		String s = "}]()[{";
//		String s = "[)(]";
		String s = "}}}";

		System.out.println(main.solution(s));
	}

	private int solution(String s) {
		int answer = 0;
				
		for (int i = 0; i < s.length(); i++) {
//			System.out.println(answer);
//			System.out.println(s);
			Stack<String> bracketStack = new Stack<>();
			for (int j = 0; j < s.length(); j++) {
				String bracket = s.substring(j, j+1);
				
				if(bracketStack.isEmpty() && (bracket.equals(")") || bracket.equals("}") || bracket.equals("]"))) {
					bracketStack.add(bracket);
					break;
				} else if(!bracketStack.isEmpty() && bracketStack.peek().equals("(") && bracket.equals(")")) {
					bracketStack.pop();
				} else if(!bracketStack.isEmpty() && bracketStack.peek().equals("{") && bracket.equals("}")) {
					bracketStack.pop();
				} else if(!bracketStack.isEmpty() && bracketStack.peek().equals("[") && bracket.equals("]")) {
					bracketStack.pop();
				} else {
					bracketStack.add(bracket);
				}
//				System.out.println(bracketStack);
			}
			
			if(bracketStack.isEmpty()) {
				answer++;
			}
			s = s.substring(1) + s.substring(0, 1);
		}
		
		return answer;
	}

}
