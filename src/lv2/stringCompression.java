package lv2;

import java.util.Stack;

public class stringCompression { // 문자열 압축

	public static void main(String[] args) {
		String s = "aabbaccc";
//		String s = "ababcdcdababcdcd";
//		String s = "abcabcdede";
//		String s = "abcabcabcabcdededededede";
//		String s = "xababcdcdababcdcd";

		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int answer = 0;

		int idx = s.length() / 2;

		while (1 <= idx) {
			Stack<String> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();

			int repeat = 1;
			for (int i = 0; i < s.length(); i += idx) {
				if (!stack.isEmpty()) {
					if (i + idx < s.length() && stack.peek().equals(s.substring(i, i += idx))) {
						repeat++;
						continue;
					} else if (i + idx < s.length() && !stack.peek().equals(s.substring(i, i += idx))) {
						String str = stack.pop();
						stack.push(String.valueOf(repeat));
						stack.push(str);
						stack.push(s.substring(i, i + idx));
						repeat = 1;
					} else if(s.length() <= i + idx) {
						stack.push(s.substring(i, s.length()));
					}
				} else {
					stack.push(s.substring(i, i + idx));
				}
			}
			System.out.println(stack);
			idx -= 1;
		}

		return answer;
	}

}
