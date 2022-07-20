package lv1;

public class ExtractionTheSquareRoot {  // 정수 제곱근 판별

	public static void main(String[] args) {
		int n = 121;
//		int n = 3;
		
		System.out.println(solution(n));
	}

	private static long solution(int n) {
		long answer = 0;
		
		if(String.valueOf(Math.round(Math.sqrt(n))).contains(".")) {
			answer = (long)Math.pow(n+1, 2);
		}else {
			answer = -1;
		}
		
		return answer;
	}
}
