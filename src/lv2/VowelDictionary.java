package lv2;

public class VowelDictionary { // 모음사전

	public static void main(String[] args) {
		String word = "AAAAE";
//		String word = "AAAE";
//		String word = "I";
//		String word = "EIO";
		System.out.println(solution(word));
	}

	static int idx = 0;
	private static int solution(String word) {
		int answer = 0;
		String[] vowel = {"A", "E", "I", "O", "U"};
		StringBuilder sb = new StringBuilder();
		DFS(5, word, vowel, sb);
		answer = idx;
		return answer;
	}

	private static void DFS(int lng, String word, String[] vowel, StringBuilder sb) {
		System.out.println(sb.toString());
		if(sb.toString().equals(word)) {  // sb가 word와 같다면 return
			System.out.println("멈추세요");
			return;
		}
		
		if(lng == sb.toString().length()) {  // 5글자가 다 채워졌다면 return
			System.out.println("5글자 return");
			return;
		}
		
		for (int i = 0; i < vowel.length; i++) {
			sb.append(vowel[i]);  // sb에 추가
			idx++;  // answer + 1번째 문자열임을 저장
			DFS(lng, word, vowel, sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}

}
