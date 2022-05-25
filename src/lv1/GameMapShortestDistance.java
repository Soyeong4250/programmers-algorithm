package lv1;

public class GameMapShortestDistance {

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
//		int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};
		
		System.out.println(solution(maps));
	}

	static int[] dr = {-1, 1, 0, 0};  // 상하좌우
	static int[] dc = {0, 0, -1, 1};  // 상하좌우
	private static int solution(int[][] maps) {
		int answer = 0;
		
		int min = dfs(maps, 0, 0, 1);
		
		return answer;
	}
	
	private static int dfs(int[][] maps, int sr, int sc, int cnt) {
		if(sr == maps.length-1 && sc == maps[0].length-1) {
			return cnt;
		}
		
		for (int i = 0; i < dr.length; i++) {
			int nr = sr + dr[i];
			int nc = sc + dc[i];
			if(0 <= nr && nr < maps.length && 0<=nc && nc < maps[0].length && maps[nr][nc] == 1) {
				dfs(maps, nr, nc, cnt+1);
			}
		}
		
		return -1;
	}

}
