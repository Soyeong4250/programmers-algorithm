package SampleQuestions;

import java.util.Arrays;

public class KakaoBlindRecuitment8_F { // [1차] 프렌즈 블록

	public static void main(String[] args) {
//		int m = 4;
//		int n = 5;
//		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

//		int m = 6;
//		int n = 6;
//		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

//		int m = 8;
//		int n = 5;
//		String[] board = {"HGNHU", "CRSHV", "UKHVL", "MJHQB", "GSHOT", "MQMJJ", "AGJKK", "QULKK"};
		
		int m = 7;
		int n = 2;
		String[] board = {"AA", "BB", "AA", "BB", "ZZ", "ZZ", "CC"};
		
		System.out.println(solution(m, n, board));
	}

	private static int solution(int m, int n, String[] board) {
		String[][] map = new String[m][n];
		v = new boolean[m][n];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = String.valueOf(board[i].charAt(j));
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		while(flag) {
			flag = false;
//			System.out.println("들어갑니다.");
			isBlock(m, n, map, v);
			for (int i = 0; i < map.length; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println(flag);
		}
		
		
		return answer;
	}

	static boolean[][] v;
	static boolean flag = true;
	static int answer = 0;
	private static void isBlock(int m, int n, String[][] map, boolean[][] v) {
		int[] dr = {0, 1, 1};
		int[] dc = {1, 0, 1};
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int cnt = 0;
//				System.out.println(i + ", " + j);
				
				for (int d = 0; d < dc.length; d++) {
					int nr = i+dr[d];
					int nc = j+dc[d];
//					System.out.println("nr : " + nr + ", nc : " + nc);
					if(0 <= nr && nr < m && 0 <= nc && nc < n && !map[i][j].equals("x") && map[i][j].equals(map[nr][nc])) {
						System.out.println("같습니다" + nr + nc);
						cnt++;
					}
				}
				
				if(cnt == 3) {
					v[i][j] = v[i+1][j] = v[i][j+1] = v[i+1][j+1] = true;
				}
				
			}
		}
		for (int k = 0; k < v.length; k++) {
			System.out.println(Arrays.toString(v[k]));
		}System.out.println();
		
		// 내려보내기
		for (int j = 0; j < n; j++) {
			for (int i = m-1; i >= 0; i--) {
				if(v[i][j]) {
					answer++;
					flag = true;
					map[i][j] = "x";
					
					for(int k = i-1; k > 0; k--) {
						if(!map[k][j].equals("x")) {
							map[i][j] = map[k][j];
							map[k][j] = "x";
						}
					}
					
					
					v[i][j] = false;
				}
			}
		}
		System.out.println(flag);
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("=================");
		
	}

}
