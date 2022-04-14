package practiceQuestions;

public class tiling {

	public static void main(String[] args) {
		int n = 4;
		
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		int answer = 0;
		
		int first = 1;
		int second = 1;
		
		for (int i = 0; i < n-1; i++) {
			answer = (first+second)%1000000007;
			first = second;
			second = answer;
		}
		
//		System.out.println(answer);
		return answer;
	}

//	private static int solution(int n) {
//		int answer = 0;
//		answer = fibo(n)%1000000007;
//		return answer;
//	}
//
//	private static int fibo(int i) {
//		if(i<=2) return i;
//		else return fibo(i-2) + fibo(i-1);
//	}

}
