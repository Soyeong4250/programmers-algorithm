package Greedy;

public class MakeBigNumber2 { // 큰 수 만들기
	
	public static void main(String[] args) {
//		String number = "1924";
//		int k = 2;
//		String number = "1231234";
//		int k = 3;
		String number = "4177252841";
		int k = 4;

		System.out.println(solution(number, k));
	}

	private static String solution(String number, int k) {
		String answer = "";
		
		StringBuilder sb = new StringBuilder();
		int index = 0;  // 다음 검토 시작할 인덱스
		for (int i = 0; i < number.length() - k; i++) {
			int max = 0;
			for (int j = index; j <= i+k; j++) {
				if(max < number.charAt(j)-'0') {
					max = number.charAt(j) - '0';
					index = j+1;
				}
			}
			sb.append(max);
		}
		
		// System.out.println(sb.toString());
		answer = sb.toString();
		return answer;
	}

}
