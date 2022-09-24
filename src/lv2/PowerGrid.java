package lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PowerGrid { // 전력망을 둘로 나누기

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = 9;
		int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };

//		int n = 4;
//		int[][] wires = {{1, 2}, {2, 3}, {3, 4}};

//		int n = 7;
//		int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};

		System.out.println(solution(n, wires));

	}
	
	private static int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		
		// 인접리스트
		int[][] adj = new int[n+1][n+1];
		
		// 양방향 입력
		for (int i = 0; i < wires.length; i++) {
			adj[wires[i][0]][wires[i][1]] = 1;
			adj[wires[i][1]][wires[i][0]] = 1;			
		}
		
		// 연결된 에지 하나씩 끊어보며 탐색
		for (int i = 0; i < wires.length; i++) {
			int s = wires[i][0];
			int e = wires[i][1];
			
			// 에지 끊기
			adj[s][e] = 0;
			adj[e][s] = 0;
			
			answer = Math.min(answer, bfs(adj, new boolean[n+1], 1, n));
			
			// 에지 원상복귀
			adj[s][e] = 1;
			adj[e][s] = 1;
		}
		
		return answer;
	}
	
	private static int bfs(int[][] adj, boolean[] v, int start, int n) {		
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			v[node] = true;
			
			for (int i = 1; i < v.length; i++) {
				if(!v[i] && adj[node][i] == 1) {  // 방문한적 없는 노드이고 현재 노드와 연결되어 있다면
					q.offer(i);
					cnt++;
				}
			}
		}
		
		return (int)Math.abs(cnt - (n - cnt));
	}

}
