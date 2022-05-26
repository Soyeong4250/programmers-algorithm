package lv1;

import java.util.LinkedList;
import java.util.Queue;

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
		
		answer = Math.min(answer, bfs(maps, 0, 0, 1));
		
		return answer;
	}
	
	private static int bfs(int[][] maps, int sr, int sc, int cnt) {
		Queue<Integer> q = new LinkedList<>();
		
		
		
		
		return -1;
	}

}
