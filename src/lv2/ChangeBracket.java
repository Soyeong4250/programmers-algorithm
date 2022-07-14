package lv2;

public class ChangeBracket { // 괄호 변환

	public static void main(String[] args) {
//		String p = "(()())()";
		String p = ")(";
//		String p = "()))((()";

		System.out.println(solution(p));
	}

	static String u, v;
	static String answer ="";
	private static String solution(String p) {
		if(balance(p)) {  // 올바른 괄호 문자열이라면
			return p;
		} else {  // 올바른 괄호 문자열이 아니라면
			cut(p);
//			System.out.println(v);
//			System.out.println(u);
			if(balance(u)) {  // u가 올바른 괄호 문자열이라면
//				System.out.println("u는 올바른 괄호 문자열입니다.");
				answer += u;
//				System.out.println("answer : " + answer);
				solution(v);
			} else {
				String emp = "(";  // (를 더한 빈 문자열
				emp += solution(v);
//				System.out.println("emp " + emp);
				emp += ")";
				for (int i = 1; i < u.length()-1; i++) {
					if(u.substring(i, i+1).equals("(")) {
						emp += ")";
					} else {
						emp += "(";
					}
				}
				answer += emp;
			}
		}
			
		return answer;
	}

	private static void cut(String p) {  // 더 이상 분리할 수 없는 괄호 문자열 u 구하기
		int pair = 0;
		u = "";
		v = "";
		for (int i = 0; i < p.length(); i++) {
//			System.out.println("u에 더해질 문자 : " + p.substring(i, i+1));
			if(p.substring(i, i+1).equals("(")) {
				u += "(";
				pair += 1;
			}else {
				u += ")";
				pair -= 1;
			}
			
			if(pair == 0) {
//				System.out.println("pair는 0");
				v += p.substring(i+1);
				return;
			}
		}
		
	}

	private static boolean balance(String p) {  // 올바른 괄호 문자열인가?
		int pair = 0;
		
		for (int i = 0; i < p.length()-1; i++) {
			if(p.substring(i, i+1).equals("(")) {
				pair += 1;
			} else {
				pair -= 1;
			}
			
			if(pair < 0) {
				return false;
			}
		} 
		
		return true;
	}

}
