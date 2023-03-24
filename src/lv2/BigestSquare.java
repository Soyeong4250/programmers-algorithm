package lv2;

public class BigestSquare { // 가장 큰 정사각형 찾기
	public static void main(String[] args) {
		BigestSquare main = new BigestSquare();

		int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
//		int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}};
//		int[][] board = {{0, 0, 0, 0}, {0, 0, 0, 0}};
//		int[][] board = {{1, 1, 1, 1}, {1, 1, 1, 1}};
//		int[][] board = {{1}};
//		int[][] board = {{0,0,0,1,1,1},{0,0,0,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1}};
//		int[][] board = {{1,1,1},{1,0,1},{1,1,1}};

		long start = System.currentTimeMillis();
		System.out.println(main.solution(board));
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간 = " + (end - start));
	}

	private int solution(int[][] board) {
		int answer = 0;
		
		int[][] memo = new int[board.length][board[0].length];
		
		for (int i = 0; i < memo.length; i++) {
			memo[i][0] = board[i][0];
		}
		for (int i = 0; i < memo[0].length; i++) {
			memo[0][i] = board[0][i];
		}
		
//		for (int k = 0; k < memo.length; k++) {
//			System.out.println(Arrays.toString(memo[k]));
//		}
		
		if(memo.length <= 1) return memo[0][0];
		
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				if(board[i][j] == 1) {
					memo[i][j] = Math.min(memo[i-1][j-1], Math.min(memo[i-1][j], memo[i][j-1])) + 1;
					if(memo[i][j] > answer) {
						answer = memo[i][j];
					}
					System.out.println(answer);
				}
//				for (int k = 0; k < memo.length; k++) {
//					System.out.println(Arrays.toString(memo[k]));
//				}
			}
		}
		
		return answer * answer;
	}
}
