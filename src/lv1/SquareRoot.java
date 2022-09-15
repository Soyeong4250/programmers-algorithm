package lv1;

public class SquareRoot { // 정수 제곱근 판별

	public static void main(String[] args) {
//		long n = 121;
		long n = 3;
		System.out.println(solution(n));
	}

	private static long solution(long n) {
		long answer = 0;
		
		double num = Math.sqrt(n);
		if(n%num == 0) {
		answer = (long)Math.pow(num+1, 2);
		} else {
			answer = -1;
		}
		return answer;
	}

}
