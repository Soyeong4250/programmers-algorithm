package lv1;

public class DotProduct { // 내적

	public static void main(String[] args) {
//		int[] a = { 1, 2, 3, 4 };
//		int[] b = { -3, -1, 0, 2 };

		int[] a = {-1, 0, 1};
		int[] b = {1, 0, -1};

		System.out.println(solution(a, b));
	}

	private static int solution(int[] a, int[] b) {
		int answer = 0;
		
		for (int i = 0; i < b.length; i++) {
			answer += a[i]*b[i];
		}
		
		return answer;
	}

}
