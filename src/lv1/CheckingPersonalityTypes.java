package lv1;

public class CheckingPersonalityTypes { // 성격 유형 검사하기

	public static void main(String[] args) {
//		String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
//		int[] choices = { 5, 3, 2, 7, 5 };

		String[] survey = {"TR", "RT", "TR"};
		int[] choices = {7, 1, 3};

		System.out.println(solution(survey, choices));
	}
	
	private static String solution(String[] survey, int[] choices) {
		int[] scores = new int[8];
		
		
		for (int i = 0; i < choices.length; i++) {
			if(choices[i] <= 3) {  // 동의일 경우
				String type = survey[i].substring(0, 1);  // 앞의 성격 유형 선택
				switch (type) {
				case "R":
					scores[0] += 4-choices[i];
					break;
				case "T":
					scores[1] += 4-choices[i];
					break;
				case "C":
					scores[2] += 4-choices[i];
					break;
				case "F":
					scores[3] += 4-choices[i];
					break;
				case "J":
					scores[4] += 4-choices[i];
					break;
				case "M":
					scores[5] += 4-choices[i];
					break;
				case "A":
					scores[6] += 4-choices[i];
					break;
				case "N":
					scores[7] += 4-choices[i];
					break;
				}
				
			} else if (choices[i] >= 5) {  // 비동의일 경우
				String type = survey[i].substring(1, 2);  // 뒤의 성격 유형 선택
				switch (type) {
				case "R":
					scores[0] += choices[i]-4;
					break;
				case "T":
					scores[1] += choices[i]-4;
					break;
				case "C":
					scores[2] += choices[i]-4;
					break;
				case "F":
					scores[3] += choices[i]-4;
					break;
				case "J":
					scores[4] += choices[i]-4;
					break;
				case "M":
					scores[5] += choices[i]-4;
					break;
				case "A":
					scores[6] += choices[i]-4;
					break;
				case "N":
					scores[7] += choices[i]-4;
					break;
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append((scores[0] < scores[1]) ? "T" : "R");
		sb.append((scores[2] < scores[3]) ? "F" : "C");
		sb.append((scores[4] < scores[5]) ? "M" : "J");
		sb.append((scores[6] < scores[7]) ? "N" : "A");
		
		return sb.toString();
	}

}
