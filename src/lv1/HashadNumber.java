package lv1;

public class HashadNumber {  // 하샤드 수

	public static void main(String[] args) {
//		int x = 10;
//		int x = 12;
//		int x = 11;
//		int x = 13;
		int x = 14;
		
		System.out.println(solution(x));
	}

	private static boolean solution(int x) {
		boolean answer = true;
		
		int sum = 0;
		int num = x;
		for (int i = String.valueOf(x).length()-1; i>= 0; i--) {
			sum += num/Math.pow(10, i);
			num %= Math.pow(10, i);
		}
		
		if(x%sum != 0) {
			answer = false;
		}
		
		return answer;
	}

}
