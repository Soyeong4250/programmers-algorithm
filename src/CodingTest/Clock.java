package CodingTest;

public class Clock {

	public static void main(String[] args) {
		int n = 6;
		
		boolean clockwise = false;
		
		System.out.println(solution(n, clockwise));

	}
	

	private static int[][] solution(int n, boolean clockwise) {
		int[][] answer = new int[n+1][n+1];
		int[][] dr = {{0, 1, 0, -1},  // > v < ^
				{1, 0, -1, 0},  // v < ^ >
				{-1, 0, 1, 0},  // ^ > v <
				{0, -1, 0, 1}};  // < ^ > v
		int[][] dc = {{1, 0, -1, 0},  // > v < ^
				{0, -1, 0, 1},  // v < ^ >
				{0, 1, 0, -1},  // ^ > v <
				{-1, 0, 1, 0}};  // < ^ > v
		if(clockwise) {
			answer[1][1] = answer[1][n] = answer[n][1] = answer[n][n] = 1;
			answer[1][2] = answer[2][n] = answer[n-1][1] = answer[n][n-1] = 2; 
			int order = 0;  // 몇번째 꼭짓점
			int d = 0;
			int nr = 0;
			int nc = 0;
			while(d < 4) {
				nr += dr[0][d];
				answer[dr[]]
			}
		}
		
		return answer;
	}

}
