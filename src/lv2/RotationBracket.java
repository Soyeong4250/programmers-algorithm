package lv2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class RotationBracket { // 괄호 회전하기

	public static void main(String[] args) {
		String s = "[](){}";
//		String s = "}]()[{";
//		String s = "[)(]";
//		String s = "}}}";

		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int answer = 0;
		
//		List<String> list = new ArrayList<>(Arrays.asList(s.split("")));
		
		Deque<String> q = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if(isBalance(s)) {
				answer++;
			}
			String first = q.pollFirst();
			
			
		}
		
		
		return answer;
	}

	private static boolean isBalance(String s) {
		Stack<String> stack = new Stack<>();
		for(int i = 0; i<s.length(); i++) {
			
		}
		
		return false;
	}

}
