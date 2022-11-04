package lv3;

public class WayToSchool { // 등굣길

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 2 } };

		System.out.println(solution(m, n, puddles));
	}

	private static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		
		int[][] memo = new int[n+1][m+1];  // 갈 수 있는 길의 수 메모
		
		for (int i = 0; i < puddles.length; i++) {
			memo[puddles[i][0]][puddles[i][1]] = -1;
		}
		
		memo[1][1] = 1;
		
//		for (int i = 1; i < memo.length; i++) {
//			for (int j = 1; j < memo[i].length; j++) {
//				System.out.print(memo[i][j]);
//			}System.out.println();
//		}
		
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < m+1; j++) {
				if(memo[i][j] == -1) {
//					System.out.println(memo[i][j] + "입니다");
					continue;
				}
				if(memo[i][j-1] >= 0 && memo[i][j] >= 0) {  // 이전(왼쪽)에 숫자가 0이상이면 더하기
					memo[i][j] = memo[i][j] + memo[i][j-1] % 1000000007;  
				}
				if(memo[i-1][j] >= 0 && memo[i][j] >= 0) {  // 이전(위쪽)에 숫자가 0이상이면 더하기
					memo[i][j] = memo[i][j] + memo[i-1][j] % 1000000007;
				}
			}
		}
		
//		for (int i = 1; i < memo.length; i++) {
//			for (int j = 1; j < memo[i].length; j++) {
//				System.out.print(memo[i][j]);
//			}System.out.println();
//		}
//		
		answer = memo[n][m] % 1000000007;
		
		return answer;
	}

}
