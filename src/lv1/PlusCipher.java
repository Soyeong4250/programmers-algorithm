package lv1;

public class PlusCipher {  // 자릿수 더하기

	public static void main(String[] args) {
//		int N = 123;
		int N = 987;
		
		System.out.println(solution(N));
	}
	
	private static int solution(int n) {
		int answer = 0;
		
		while(n > 0) {
			answer += n%10;
			n /= 10;
		}
		
		return answer;
	}

}
