package lv1;

public class Rest1 { // 나머지가 1이 되는 수 찾기

	public static void main(String[] args) {
//		int n = 10;
//		int n = 12;
		int n = 20;

		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = 0;
		
		int num = n-1;
		
		answer = isPrime(num);
		
		return answer;
	}

	private static int isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num%i == 0) {
				return i;
			}
		}
		
		return num;
	}

}
