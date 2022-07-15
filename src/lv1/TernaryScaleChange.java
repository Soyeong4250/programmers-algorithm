package lv1;

public class TernaryScaleChange { // 3진법 뒤집기

	public static void main(String[] args) {
		int n = 45;
//		int n = 125;

		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		
		// 3진법
		while(n > 0) {
			sb.append(n%3);
			n /= 3;
		}
		
//		String str = sb.toString();
//		for (int i = 0; i < str.length(); i++) {
////			System.out.println(Integer.parseInt(str.substring(str.length()-i-1, str.length()-i)) * Math.pow(3, i));
//			answer += Integer.parseInt(str.substring(str.length()-i-1, str.length()-i)) * Math.pow(3, i);  // 3진법 -> 10진법
//		}
		
		answer = Integer.parseInt(sb.toString(), 3);
		
		return answer;
	}

}
