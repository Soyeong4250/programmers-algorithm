package lv1;

public class HidePhoneNumber { // 핸드폰 번호 가리기

	public static void main(String[] args) {
		String phone_number = "01033334444";
//		String phone_number = "027778888";

		System.out.println(solution(phone_number));
	}

	private static String solution(String phone_number) {
		String answer = "";
		answer = phone_number.replaceAll(".(?=.{4})", "*");
		return answer;
	}

//	private static String solution(String phone_number) {
//		String answer = "";
//		
//		for (int i = 0; i < phone_number.length(); i++) {
//			if(i < phone_number.length()-4) {
//				answer += "*";
//			} else {
//				answer += phone_number.substring(i, i+1);
//			}
//		}
//		
//		return answer;
//	}

}
