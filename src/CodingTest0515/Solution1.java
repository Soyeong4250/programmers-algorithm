package CodingTest0515;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {

	public static void main(String[] args) {
		int n = 6;
//		int n = 8;
		String text = "hi bye";
//		String text = "hello dev programmers";
//		int second = 1;
//		int second = 2;
//		int second = 6;
		int second = 13;
//		int second = 15;
		
		System.out.println(solution(n, text, second));
	}

	private static String solution(int n, String text, int second) {
		String answer = "";
		
		// 전광판 길이만큼 text 길이 늘이기
		for (int i = 0; i < n; i++) {
			text += "_";
		}
		
//		System.out.println(text);
		
		Queue<String> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			q.add("_");
		}
		
//		System.out.println(q);
		int index = 0;
		
		while(index < second) {
			index++;
			q.poll();
			if(index%text.length() == 0) {
				q.add("_");
			} else {
				if(text.substring(index%text.length()-1, index%text.length()).equals(" ")) {
					q.add("_");
				}else {
					q.add(text.substring(index%text.length()-1, index%text.length()));
				}
			}
		}

		
		while(!q.isEmpty()) {
			answer += q.poll();
		}
		
		return answer;
	}

}
