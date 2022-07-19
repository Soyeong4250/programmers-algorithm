package lv1;

public class subaksu {  // 수박수박수박수박수박수?

	public static void main(String[] args) {
		int n = 3;
//		int n = 4;
		
		System.out.println(solution(n));
	}

	private static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= n; i++) {
			if(i%2 != 0) {
				sb.append("수");
			}else {
				sb.append("박");
			}
		}
		
		return sb.toString();
	}

}
