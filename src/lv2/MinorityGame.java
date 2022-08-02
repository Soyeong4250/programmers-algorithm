package lv2;

public class MinorityGame { // N진수 게임

	public static void main(String[] args) {
//		int n = 2;
//		int t = 4;
//		int m = 2;
//		int p = 1;

//		int n = 16;
//		int t = 16;
//		int m = 2;
//		int p = 1;

		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;

		System.out.println(solution(n, t, m, p));
	}

	private static String solution(int n, int t, int m, int p) {
		StringBuilder answer = new StringBuilder();

		StringBuilder sb = new StringBuilder();
		int num = 0;
		while (sb.toString().length() <= t * m) {
			sb.append(Integer.toString(num, n));
			num++;
		}

//		System.out.println(sb.toString());

		int idx = p - 1;

		while (answer.toString().length() < t) {
//			System.out.println(idx);	
			String str = sb.toString().substring(idx, idx + 1);
			if (str.matches("[a-f]")) {
				answer.append(sb.toString().substring(idx, idx + 1).toUpperCase());
			} else {
				answer.append(sb.toString().substring(idx, idx + 1));
			}
			idx += m;

		}
		return answer.toString();
	}

}
