package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Friends4Block { // 프렌즈4블록

	public static void main(String[] args) {
		Friends4Block main = new Friends4Block();

		// 14
		int m = 4;
		int n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

		// 15
//		int m = 6;
//		int n = 6;
//		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

		System.out.println(main.solution(m, n, board));
	}

	static boolean[][] check;
	private int solution(int m, int n, String[] board) {
		int answer = 0;
		
		String[][] map = new String[m][n];
		for (int i = 0; i < m; i++) {
			map[i] = board[i].split("");
		}
		
		for (int i = 0; i < m; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		check = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				List<int[]> spotList = bfs(map, i, j);
				if(spotList.size() >= 4) {
					for (int k = 0; k < spotList.size(); k++) {
						int[] spot = spotList.get(0);
						check[spot[0]][spot[1]] = true;
					}
				}
			}
		}
		
		return answer;
	}
	
	private List<int[]> bfs(String[][] map, int r, int c) {
		int[] dr = {-1, 0, 1, 0};  // 상 우 하 좌
		int[] dc = {0, 1, 0, -1};
		
		List<int[]> spotList = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{r, c});
		
		while(!queue.isEmpty()) {
			int[] spot = queue.poll();
			if(map[r][c].equals(map[spot[0]][spot[1]])) {
				spotList.add(spot);
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr = spot[0] + dr[i];
				int nc = spot[1] + dc[i];
				
				if(isMove(map, nr, nc)) {
				
					if(map[r][c].equals(map[nr][nc]) && !check[nr][nc]) {
						queue.add(new int[] {nr, nc}); 
					} else if(!map[r][c].equals(map[nr][nc]) && check[nr][nc]) {
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(check[i]));
		}
		System.out.println("------------");
		
		return spotList;
	}

	private boolean isMove(String[][] map, int nr, int nc) {
		if(0 <= nr && nr < map.length && 0 <= nc && nc < map[0].length) {
			return true;
		}
		
		return false;
	}

}
