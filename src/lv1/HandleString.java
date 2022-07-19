package lv1;

public class HandleString {  // 문자열 다루기 기본

	public static void main(String[] args) {
		String s = "a234";
//		String s = "1234";
		
		System.out.println(solution(s));
	}

	private static boolean solution(String s) {
		boolean answer = true;
		
		if(s.length() == 4 || s.length() == 6) {
			if(s.matches(".*[^0-9].*")) {
				answer = false;
			}
		} else answer = false;
		
		return answer;
	}
}
