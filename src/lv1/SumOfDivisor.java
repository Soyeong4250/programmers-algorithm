package lv1;

public class SumOfDivisor {  // 약수의 합

	public static void main(String[] args) {
//		int n = 12;
		int n = 5;
		
		System.out.println(solution(n));
	}
	
	private static int solution(int n) {
		int answer = 0;
		
		for (int i = 1; i <= Math.sqrt(n); i++) {
			
			if(n%i == 0) {
				if(i == n/i) {
					answer += i;
					continue;
				}
				answer += i;
				answer += n/i;
			}
			
		}
		
		return answer;
	}

}
