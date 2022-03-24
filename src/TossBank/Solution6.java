package TossBank;

public class Solution6 {

	public static void main(String[] args) {
		String[] prj = {"DBEX", "ACE", "CDX", "ABGX"};  // 각 프로젝트별 참여 인원
		int n = 2;  // 코드 리뷰를 받아야 하는 수
		int k = 3;  // 최대 리뷰할 수 있는 동료의 수
		
		System.out.println(solution(prj, n, k));

	}

	private static String solution(String[] prj, int n, int k) {
		String answer = "";  // 코드 리뷰
		
		for (int i = 0; i < prj.length; i++) {
			Combination(prj[i], 0, n, answer);
		}
		
		return answer;
	}

	private static void Combination(String str, int idx, int n, String answer) {
		
		char[] tmp = str.toCharArray();
		for (int i = idx; i < tmp.length; i++) {
			
		}
	}

}
