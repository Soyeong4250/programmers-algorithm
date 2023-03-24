package lv2;

public class BigestSquare { // 가장 큰 정사각형 찾기
	public static void main(String[] args) {
		BigestSquare main = new BigestSquare();

		int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
//		int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}};

		System.out.println(main.solution(board));
	}

	private int solution(int[][] board) {
		int answer = 0;
		
		int line = 0;
		
//		boolean[][] v = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 1) {
					line = checkLine(board, i, j);
					answer = answer < line*line ? line*line : answer;
				}
//				for (int k = 0; k < v.length; k++) {
//					System.out.println(Arrays.toString(v[k]));
//				}
			}
		}
		
		return answer;
	}
	
	private int checkLine(int[][] board, int sr, int sc) {
		int nr = sr;
		int nc = sc;
		
		while(nr < board.length && nc < board[0].length) {
			if(board[nr][nc] == 0) {
				break;
			}
			nr++;
			nc++;
		}
		
		return nr-sr;
	}
}
