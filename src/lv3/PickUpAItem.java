package lv3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Spot {
	int x;
	int y;
	int depth;
	
	public Spot(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}

public class PickUpAItem {

	public static void main(String[] args) {
//		int[][] rectangle = { { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 } };
//		int characterX = 1;
//		int characterY = 3;
//		int itemX = 7;
//		int itemY = 8;

//		int[][] rectangle = {{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}};
//		int characterX = 9;
//		int characterY = 7;
//		int itemX = 6;
//		int itemY = 1;

		int[][] rectangle = {{1, 1, 5, 7}};
		int characterX = 1;
		int characterY = 1;
		int itemX = 4;
		int itemY = 7;

//		int[][] rectangle = {{2, 1, 7, 5}, {6, 4, 10, 10}};
//		int characterX = 3;
//		int characterY = 1;
//		int itemX = 7;
//		int itemY = 10;

//		int[][] rectangle = {{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}};
//		int characterX = 1;
//		int characterY = 4;
//		int itemX = 6;
//		int itemY = 3;

		PickUpAItem main = new PickUpAItem();
		int result = main.solution(rectangle, characterX, characterY, itemX, itemY);
		System.out.println(result);
	}

	private int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int[][] map = new int[102][102];  
		// 좌표 2배씩 늘리기
		characterX *= 2;
		characterY *= 2;
		itemX *= 2;
		itemY *= 2;		
		for (int i = 0; i < rectangle.length; i++) {
			for (int j = 0; j < rectangle[i].length; j++) {
				rectangle[i][j] *= 2;
			}
		}
		
		int[] dr = { 0, 1, 0, -1 }; // → ↓ ← ↑
		int[] dc = { 1, 0, -1, 0 }; // → ↓ ← ↑

		// 각 직사각형의 위치 표시
		map = markEdge(map, rectangle, dr, dc);

		// 확인
//		print(map);

//		System.out.println("-----------------------");
		// 각 사각형 내의 1(표시된 부분) 지우기
		map = unmarkEdge(map, rectangle, dr, dc);

		// 확인
//		print(map);

		// 더 짧은 거리 구하기
		int result = bfs(map, new boolean[map.length][map[0].length], dr, dc, characterX, characterY, itemX, itemY);

		return result;
	}

	private int bfs(int[][] map, boolean[][] v, int[] dr, int[] dc, int characterX, int characterY, int itemX,
			int itemY) {
		int dis = 0;
		Queue<Spot> q = new LinkedList<>();

		q.add(new Spot(characterX, characterY, 0));
		v[characterX][characterY] = true;

		while (!q.isEmpty()) {
			Spot s = q.poll();


			if(s.x == itemX && s.y == itemY) {
				dis = s.depth;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nr = s.x + dr[d];
				int nc = s.y + dc[d];
				int depth = s.depth + 1;
//				System.out.println(nr/2 + ", " + nc/2);
				
				
				if (map[nr][nc] == 1 && !v[nr][nc]) {
					q.add(new Spot(nr, nc, depth));
					v[nr][nc] = true;
				}
			}

		}

		return dis/2;
	}

	private int[][] unmarkEdge(int[][] map, int[][] rectangle, int[] dr, int[] dc) {

		for (int i = 0; i < rectangle.length; i++) {
			int sr = rectangle[i][0];
			int sc = rectangle[i][1];
			int er = rectangle[i][2];
			int ec = rectangle[i][3];

			for (int r = sr + 1; r < er; r++) {
				for (int c = sc + 1; c < ec; c++) {
					map[r][c] = 0;
				}
			}
		}

		return map;
	}

	private int[][] markEdge(int[][] map, int[][] rectangle, int[] dr, int[] dc) {

		for (int i = 0; i < rectangle.length; i++) {
			int sr = rectangle[i][0];
			int sc = rectangle[i][1];
			int d = 0;
			while (d < 4) {
				map[sr][sc] = 1;
				sr += dr[d];
				sc += dc[d];
				if ((sr == rectangle[i][0] && sc == rectangle[i][1]) || (sr == rectangle[i][0] && sc == rectangle[i][3])
						|| (sr == rectangle[i][2] && sc == rectangle[i][1])
						|| (sr == rectangle[i][2] && sc == rectangle[i][3])) {
					d++;
				}
			}
		}

		return map;
	}

	private void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	private void print(boolean[][] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.println(Arrays.toString(v[i]));
		}
	}

}
