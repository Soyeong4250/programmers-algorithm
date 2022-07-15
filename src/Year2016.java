
public class Year2016 {  // 2016년

	public static void main(String[] args) {
		int a = 5;
		int b = 24;
//		int a = 1;
//		int b = 10;
		
		System.out.println(solution(a, b));
	}

	private static String solution(int a, int b) {
		String answer = "";
		String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  // 2016년은 윤년이라서 2월달이 29일까지
		
		int date = 0;
		
		for (int i = 0; i < a-1; i++) {
			date += day[i];
		}
		date += b;
		date -= 1;  // 1월 1일부터 시작이니까
		answer = week[date%7];
		
		return answer;
	}

}
