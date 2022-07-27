package lv2;

public class JadenCase {  // JadenCase 문자열 만들기

	public static void main(String[] args) {
//		String s = "3people unFollowed me";
		String s = "for the last week";
		
		System.out.println(solution(s));
	}
	
	private static String solution(String s) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			String str = s.substring(i, i+1);
			if(i == 0 || s.charAt(i-1)==' ') {
				sb.append(str.toUpperCase());
			} else {
				sb.append(str.toLowerCase());
			}
		}
		
		answer = sb.toString();
		
		return answer;
	}

}
