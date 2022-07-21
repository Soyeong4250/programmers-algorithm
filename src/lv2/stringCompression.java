package lv2;

public class stringCompression { // 문자열 압축

	public static void main(String[] args) {
//		String s = "aabbaccc";
//		String s = "ababcdcdababcdcd";
//		String s = "abcabcdede";
//		String s = "abcabcabcabcdededededede";
//		String s = "xababcdcdababcdcd";
//		String s = "ayayaysysyysssayaya";
		String s = "a";

		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int answer = s.length();

		for (int i = 1; i <= s.length() / 2; i++) { // 자를 문자열 길이
			StringBuilder sb = new StringBuilder();  // 문자열을 합칠 StringBuilder
			int level = 1;  // 중복된 횟수
			String str = s.substring(0, i);  // 첫 문자열
			for (int j = i; j < s.length(); j += i) {  // 일정한 크기로 문자열 자르기
				int end = (j+i<=s.length())?j+i:s.length();
				if (str.equals(s.substring(j, end))) {  // 이번 문자열과 이전 문자열이 같다면 level+=1
					level += 1;
				} else {  // 이번 문자열과 이전 문자열이 다르다면 
					if (level > 1) { // level이 1보다 클때만 StringBuilder에 합치기
						sb.append(level);
					}
					sb.append(str);  // 이전 문자열 담기
//					System.out.println(str + " 더해짐");
					str = s.substring(j, end);  // 이번 문자열을 비교할 새로운 문자열로 넣기
//					System.out.println("다음 str은 " + str);
					level = 1;  // level은 다시 1로 되돌리기
				}

			}
			if(level > 1) {
				sb.append(level);
			}
			sb.append(str);  // 마지막 문자열은 반복문 안에 포함되지 않았으므로 따로 담아주기

			System.out.println(sb.toString());
			if (answer > sb.length()) {  // StringBuilder의 길이가 작을 때에만 답의 후보가 되므로 바꿔주기
				System.out.println("answer보다 길이 작음");
				answer = sb.length();
			}
		}

		return answer;
	}

}
