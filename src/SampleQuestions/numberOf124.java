package SampleQuestions;

public class numberOf124 { // 124나라의 숫자

	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		String[] arr = {"4", "1", "2"};  // 3으로 나눈 나머지
		
		while (n>0) {
			int tmp = n%3;
			sb.append(arr[tmp]);
			
			n /= 3;
			
			if(tmp == 0) {
				n -= 1;
			}
		}
		
		return sb.reverse().toString();
	}

}
