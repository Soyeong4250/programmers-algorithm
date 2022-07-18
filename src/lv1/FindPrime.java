package lv1;

public class FindPrime {  // 소수찾기

	public static void main(String[] args) {
		int n = 10;
//		int n = 5;
		
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = 0;
		
		for (int i = 2; i <= n; i++) {
			if(i == 2 || i == 3) { 
				answer++;
			} else {
				answer += isPrime(i);			
			}
		}
		
		return answer;
	}

	private static int isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if(n%i == 0) {
				return 0;
			}
		}
		return 1;
	}

}
