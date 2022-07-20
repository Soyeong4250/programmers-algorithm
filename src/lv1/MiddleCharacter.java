package lv1;

public class MiddleCharacter {  // 가운데 글자 가져오기

	public static void main(String[] args) {
//		String s = "abcde";
		String s = "qwer";
		
		System.out.println(solution(s));
	}

	private static String solution(String s) {
		String answer = "";
		
		if(s.length()%2 == 0) {
			answer += s.charAt(s.length()/2-1);
		}
		answer += s.charAt(s.length()/2);
		
		return answer;
	}
}
