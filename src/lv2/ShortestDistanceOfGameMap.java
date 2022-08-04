package lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceOfGameMap { // 게임 맵 최단거리

	public static void main(String[] args) {
//		int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
		int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};

		System.out.println(solution(maps));
	}

	private static int solution(int[][] maps) {
		// 1. 최단거리를 구하기 위해 BFS 활용
		return bfs(maps, new boolean[maps.length][maps[0].length]);
	}

	static class Spot {
		int x;
		int y;
		int cnt;
		public Spot(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	private static int bfs(int[][] maps, boolean[][] v) {
		boolean flag = false;  // 도착하지 못하는 경우를 위한 flag
		int answer = 0;  // 정답변수
		int[] dr = {-1, 1, 0, 0};  // 행인덱스 이동배열(상 하 좌 우)
		int[] dc = {0, 0, -1, 1};  // 열인덱스 이동배열(상 하 좌 우)
		
		// BFS를 실행하기 위한 Queue 생성
		Queue<Spot> q = new LinkedList<>();
		// 처음 위치의 인덱스 q에 삽입
		q.add(new Spot(0, 0, 1));
		// 처음 위치 방문한 것으로 표시
		v[0][0] = true;
		
		while(!q.isEmpty()) {  // q의 원소가 모두 없어질 때까지 반복
			Spot s = q.poll();
			
			// q가 비어있지 않아도 목표위치에 도착했다면 해당 위치까지 지나온 칸의 개수 정답변수에 넣고 반복문 멈춤
			if(s.x == maps.length-1 && s.y == maps[0].length-1) {
				answer = s.cnt;
				flag = true;  // 도착했으므로 flag 변수 변경
				break;
			}
			
			for(int i=0; i<dr.length; i++) {
				int nr = s.x + dr[i];
				int nc = s.y + dc[i];
				if(0 <= nr && nr < maps.length && 0 <= nc && nc < maps[0].length && !v[nr][nc] && maps[nr][nc] == 1) {  // 전진할 수 있는 칸이 있다면 q에 담기
//					System.out.println(nr + ", " + nc + ", " + (s.cnt + 1));
					q.add(new Spot(nr, nc, s.cnt+1));
					v[nr][nc] = true;  // 방문한 것으로 처리
				}
			}
//			for (int i = 0; i < v.length; i++) {
//				System.out.println(Arrays.toString(maps[i]));
//			}
//			System.out.println("===================================");
		}
		
		if(!flag) {  // 방문하지 못했다면
			return -1;
		}
		
		return answer;
	}

}
