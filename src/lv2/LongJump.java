package lv2;

public class LongJump { // 멀리뛰기

	public static void main(String[] args) {
		LongJump main = new LongJump();

		int n = 1;
//		int n = 4;
//		int n = 3;

		System.out.println(main.solution(n));
	}

	private long solution(int n) {
		long answer = n;
		
		long first = 1;
		long second = 2;
		
		
		for (int i = 3; i <= n; i++) {
			answer = (first + second)%1234567;
			first = second;
			second = answer;
		}
		
		return answer%1234567;
	}

}
