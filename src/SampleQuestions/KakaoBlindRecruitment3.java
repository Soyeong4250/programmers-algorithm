package SampleQuestions;

public class KakaoBlindRecruitment3 { // 신규 아이디 추천

	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
//		String new_id = "z-+.^.";
//		String new_id = "=.=";
//		String new_id = "123_.def";		
//		String new_id = "abcdefghijklmn.p";
//		String new_id = ".....";
//		String new_id = "a";
//		String new_id = "/dfeSg/Ew.";

		System.out.println(solution(new_id));
	}

	private static String solution(String new_id) {
		// 1단계
		new_id = new_id.toLowerCase();
		System.out.println("1단계 : " + new_id);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < new_id.length(); i++) {
			char ch = new_id.charAt(i);
//			if (('a' <= ch && ch <= 'z') || ('0' <= ch && ch <= '9') || ch == '-' || ch == '_' || ch == '.') { // 2단계
//				sb.append(ch);
//			}
			if (Character.isLowerCase(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.') { // 2단계
				sb.append(ch);
			}
		}
		new_id=sb.toString();
		System.out.println("2단계 : " + new_id);
		
		// 3단계
		while(new_id.contains("..")) {
			new_id = new_id.replace("..", ".");
		}
		System.out.println("3단계 : " + new_id);

		// 4단계
//		if(new_id.charAt(0) == '.') {
//			new_id = new_id.substring(1);
//		}
//		if(new_id.length() >= 1 && new_id.charAt(new_id.length()-1) == '.') {
//			new_id = new_id.substring(0, new_id.length()-1);
//		}
		if(new_id.startsWith(".")) {
			new_id = new_id.substring(1);
		}
		if(new_id.endsWith(".")) {
			new_id = new_id.substring(0, new_id.length()-1);
		}

		System.out.println("4단계 : " + new_id);

		if (new_id.length() == 0) { // 5단계
			new_id = "a";

		} else if (new_id.length() >= 16) { // 6단계
			System.out.println("16자 이상입니다.");
			new_id = new_id.substring(0, 15); // 문자열 자르기
			if (new_id.charAt(new_id.length() - 1) == '.') {
				new_id = new_id.substring(0, new_id.length()-1);
			}
		}

		System.out.println("5~6단계 : " + new_id);

		// 7단계
		if (new_id.length() <= 2) {
			char ch = new_id.charAt(new_id.length() - 1);
			while (true) {
				if (new_id.length() >= 3) {
					break;
				}
				new_id += ch;
			}
		}

		System.out.println("7단계 : " + new_id);

		return new_id;
	}

}
