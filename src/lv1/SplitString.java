package lv1;

public class SplitString { // 문자열 나누기

	public static void main(String[] args) {
		SplitString main = new SplitString();

		// 3
//		String s = "banana";

		// 6
//		String s = "abracadabra";

		// 3
//		String s = "aaabbaccccabba";

		// 1
//		String s = "aaaaaaaaa";

		// 2
		String s = "abaaaabb";

		System.out.println(main.solution(s));
	}

	// Refactor
	private int solution(String s) {
		
		int answer = 0;
		char first = '0';
		int xCnt = 0;
		int notXCnt = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if(first == '0') {
				first = s.charAt(i);
				xCnt += 1;
			} else if(first == s.charAt(i)) {
				xCnt += 1;
			} else if(first != s.charAt(i)) {
				notXCnt += 1;
			}
			
			if(xCnt == notXCnt) {
				answer += 1;
				
				first = '0';
				xCnt = 0;
				notXCnt = 0;
			}
		}
		
		if(xCnt != notXCnt) {
			answer += 1;
		}
		
		return answer;
	}

	/*
	 * private int solution(String s) { int answer = 0;
	 * 
	 * while(!s.isEmpty()) { System.out.println("s = " + s);
	 * 
	 * char target = s.charAt(0); int xCnt = 1; int notXCnt = 0;
	 * 
	 * for (int i = 1; i < s.length(); i++) { if(target == s.charAt(i)) { xCnt += 1;
	 * } else { notXCnt += 1; }
	 * 
	 * if(xCnt == notXCnt) { answer += 1; s = s.substring(i+1); break; } }
	 * 
	 * if(notXCnt == 0) { answer += 1; break; } else if (xCnt != notXCnt) { answer
	 * += 1; break; } }
	 * 
	 * return answer; }
	 */

}
