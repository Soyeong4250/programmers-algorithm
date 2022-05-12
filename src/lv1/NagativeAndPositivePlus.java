package lv1;

public class NagativeAndPositivePlus { // 음양 더하기

	public static void main(String[] args) {
		int[] absolutes = { 4, 7, 12 };
		boolean[] signs = { true, false, true };
//		int[] absolutes = { 1, 2, 3 };
//		boolean[] signs = { false, false, true };

		System.out.println(solution(absolutes, signs));
	}

	private static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		
		for (int i = 0; i < signs.length; i++) {
			if(signs[i] == false) {
				answer -= absolutes[i];
			}else {
				answer += absolutes[i];
			}
		}
		
		return answer;
	}

}
