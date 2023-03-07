package lv2;

public class TicTacToe { // 혼자서 하는 틱택토

	public static void main(String[] args) {
		TicTacToe main = new TicTacToe();

//		String[] board = { "O.X", ".O.", "..X" };
//		String[] board = {"OOO", "...", "XXX"};
//		String[] board = {"...", ".X.", "..."};
		String[] board = {"...", "...", "..."};

		System.out.println(main.solution(board));
	}

	private int solution(String[] board) {
		char[][] map = new char[3][3];

		int o = 0;
		int x = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				map[i][j] = board[i].charAt(j);
				if (map[i][j] == 'O') {
					o++;
				} else if (map[i][j] == 'X') {
					x++;
				}
			}
		}

		if (o < x || o - x > 1) {
			return 0;
		}
		
		int oLine = winner(map, 'O');
		int xLine = winner(map, 'X');

		if (oLine > 0 && xLine > 0) {
			return 0;
		}
		if (oLine > 0) {
			if (o == x) {
				return 0;
			}
		}
		if (xLine > 0) {
			if (o > x) {
				return 0;
			}
		}
		return 1;
	}

	private int winner(char[][] map, char c) {
		int cnt = 0;
		
		if(map[0][0] == c && map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
			cnt++;
		}
		if(map[0][2] == c && map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
			cnt++;
		}
		
		for (int i = 0; i < map.length; i++) {
			if(map[i][0] == c && map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
				cnt++;
			}
			if(map[0][i] == c && map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
				cnt++;
			}
		}
		
		return cnt;
	}

}
