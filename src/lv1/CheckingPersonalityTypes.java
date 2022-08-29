package lv1;

public class CheckingPersonalityTypes { // 성격 유형 검사하기

	public static void main(String[] args) {
		String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
		int[] choices = { 5, 3, 2, 7, 5 };

//		String[] survey = {"TR", "RT", "TR"};
//		int[] choices = {7, 1, 3};

		System.out.println(solution(survey, choices));
	}

	class Types {
		int rs;
		int ts;
		int cs;
		int fs;
		int js;
		int ms;
		int as;
		int ns;
		
		public Types(int rs, int ts, int cs, int fs, int js, int ms, int as, int ns) {
			this.rs = rs;
			this.ts = ts;
			this.cs = cs;
			this.fs = fs;
			this.js = js;
			this.ms = ms;
			this.as = as;
			this.ns = ns;
		}
	}
	
	private static String solution(String[] survey, int[] choices) {
		String answer = "";
		int r = 0;
		int t = 0;
		int c = 0;
		int f = 0;
		int j = 0;
		int m = 0;
		int a = 0;
		int n = 0;
		
		
		for (int i = 0; i < choices.length; i++) {
			if(choices[i] <= 3) {  // 동의일 경우
				String type = survey[i].substring(0, 1).toLowerCase();  // 앞의 성격 유형 선택
				switch (type) {
				case "r":
					
					break;
				case "t":
					
					break;
				case "c":
					
					break;
				case "f":
					
					break;
				case "j":
					
					break;
				case "m":
					
					break;
				case "a":
					
					break;
				case "n":
					
					break;
				}
				
			} else if (choices[i] >= 5) {  // 비동의일 경우
				String type = survey[i].substring(1, 2);  // 뒤의 성격 유형 선택
				
			}
		}
		
		return answer;
	}

}
