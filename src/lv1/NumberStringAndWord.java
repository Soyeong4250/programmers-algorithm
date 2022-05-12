package lv1;

public class NumberStringAndWord {  // 숫자 문자열과 영단어

	public static void main(String[] args) {
//		String s = "one4seveneight";
		String s = "23four5six7";
		
		System.out.println(solution(s));
	}

//	private static int solution(String s) {
//		int answer = 0;
//		
//		s = s.replaceAll("zero", "0");
//		s = s.replaceAll("one", "1");
//		s = s.replaceAll("two", "2");
//		s = s.replaceAll("three", "3");
//		s = s.replaceAll("four", "4");
//		s = s.replaceAll("five", "5");
//		s = s.replaceAll("six", "6");
//		s = s.replaceAll("seven", "7");
//		s = s.replaceAll("eight", "8");
//		s = s.replaceAll("nine", "9");
//		
////		System.out.println(s);
//		
//		answer = Integer.parseInt(s);
//		return answer;
//	}
	private static int solution(String s) {
		int answer = 0;
		
		String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		for(int i=0; i<words.length; i++) {
			s = s.replaceAll(words[i], nums[i]);
		}
		
//		System.out.println(s);
		
		answer = Integer.parseInt(s);
		return answer;
	}
}
