package lv1;

public class CheckingPersonalityTypes { // 성격 유형 검사하기

	public static void main(String[] args) {
		String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
		int[] choices = { 5, 3, 2, 7, 5 };

//		String[] survey = {"TR", "RT", "TR"};
//		int[] choices = {7, 1, 3};

		System.out.println(solution(survey, choices));
	}

	private static String solution(String[] survey, int[] choices) {
		String answer = "";
		String[] types = new String[4];
		
		for (int i = 0; i < choices.length; i++) {
			if(choices[i] <= 3) {  // 동의일 경우
				String type = survey[i].substring(0, 1);  // 앞의 성격 유형 선택
				
			}
		}
		
		return answer;
	}

}
