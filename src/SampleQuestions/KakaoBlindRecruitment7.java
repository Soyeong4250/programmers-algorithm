package SampleQuestions;

import java.util.Stack;

public class KakaoBlindRecruitment7 { // 괄호 변환

	public static void main(String[] args) {
		String p = "(()())()";
//		String p = ")(";
//		String p = "()))((()";

		System.out.println(solution(p));
	}

	static String u, v;

	private static String solution(String p) {
//		// 1단계
//		if (p.length() == 0) {
//			u = "";
//			
//			return u;
//		}
		step(p);

		// 3단계
		if (isPair(u)) { // 짝이 맞는 올바른 괄호 문자열이라면
			step(v);
			u += v;
		} else { // 4단계
			if (v.length() == 0) { // 빈 문자열이라면
				v += '(';
			}

			step(v);

			v += ')';
			u = u.substring(1, u.length());
			for (int i = 0; i < u.length(); i++) {
				if (u.charAt(i) == '(') {
					u += ')';
				} else {
					u += '(';
				}
			}
		}

		return u;
	}

	private static void step(String p) {
		// 2단계
		int left = 0; // (
		int right = 0; // )
		StringBuilder sb = new StringBuilder();
		String u = "";
		String v = "";
		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);

			if (ch == '(') {
				left++;
				sb.append('(');
			} else {
				right++;
				sb.append(')');
			}

			if (left == right) {
				break;
			}
		}
		u = sb.toString();
		v = p.replace(u, "");

	}

	private static boolean isPair(String p) {
		// 1단계
		if (p.length() == 0) {
			u = "";

			return u;
		}
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);
			if (stack.isEmpty())
				stack.push(ch);
			else if (!stack.isEmpty() && stack.peek() != ch) {
				stack.pop();
			} else if (!stack.isEmpty() && stack.peek() == ch) {
				stack.push(ch);
			}
		}

		if (stack.isEmpty())
			return true;
		else
			return false;
	}

}
