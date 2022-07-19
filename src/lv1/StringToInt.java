package lv1;

public class StringToInt {  // 문자열을 정수로 바꾸기

	public static void main(String[] args) {
		String s = "1234";
		
		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int answer = 0;
		
		answer = Integer.parseInt(s);
		
		return answer;
	}
}
