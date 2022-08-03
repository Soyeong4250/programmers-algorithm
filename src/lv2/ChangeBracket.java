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
		String answer = "";
		
		// 1단계
		if(p.length() == 0) {
			return answer;
		}
		
		// 2단계
		StringBuilder u = new StringBuilder();
		StringBuilder v = new StringBuilder();
		int bracket = 0;
		for(int i=0; i<p.length(); i++) {
			u.append(p.charAt(i));
			if(p.charAt(i) == '(') bracket++;
			else bracket--;
			
			if(bracket == 0) {  // u가 균형잡힌 문자열이라면
				v.append(p.substring(i+1));
//				System.out.println("u는 " + u.toString());
//				System.out.println("v는 " + v.toString());
				break;
			}
		}
		
		// 3단계 & 4단계
		if(isBalance(u.toString())) {  // u가 올바른 괄호 문자열이라면
//			System.out.println("u는 " + u + "로 올바른 괄호 문자열입니다");
			answer += u.toString();
			answer += solution(v.toString());
		} else {
//			System.out.println("u는 " + u + "로 올바른 괄호 문자열이 아닙니다");
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			sb.append(solution(v.toString()));
			sb.append(")");
			for(int i=1; i< u.length()-1; i++) {
				if(u.charAt(i) == '(') {
					sb.append(')');
				} else {
					sb.append('(');
				}
			}
			answer = sb.toString();
		}
		
		return answer;
	}

	private static boolean isBalance(String u) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < u.length(); i++) {
			char b = u.charAt(i);
			if(stack.isEmpty() && b==')') {  // 첫 괄호가 닫는 괄호라면 올바른 괄호 x
				return false;
			}
			if(!stack.isEmpty() && stack.peek() == '(' && b == ')') {
				stack.pop();
			} else {
				stack.push(b);
			}
		}
		
//		System.out.println(stack);
		if(!stack.isEmpty()) {  // 스택이 비어있지 않다면 올바른 괄호 x
			return false;
		}
		return true;
	}

}
