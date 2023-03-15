package lv2;

public class JumpAndTeleport { // 점프와 순간이동

	public static void main(String[] args) {
		JumpAndTeleport main = new JumpAndTeleport();

//		int N = 5;
//		int N = 6;
//		int N = 3;
		int N = 12;
//		int N = 5000;

		System.out.println(main.solution(N));
	}

	private int solution(int n) {
		int result = 0;
		
		while(n > 1) {
			if(n%2 != 0) {
				n -= 1;
				result += 1;
			} else {
				n /= 2;
			}
		}
		
		if(n <= 1) {
			result += n;
		}
		
		return result;
	}

}
