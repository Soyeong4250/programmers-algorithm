package lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PowerGrid { // 전력망을 둘로 나누기

	public static void main(String[] args) {
//		int n = 9;
//		int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };

//		int n = 4;
//		int[][] wires = {{1, 2}, {2, 3}, {3, 4}};

		int n = 7;
		int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
		PowerGrid powerGrid = new PowerGrid();

		System.out.println(powerGrid.solution(n, wires));

	}
	
	private int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		
		int[][] adj = new int[n+1][n+1];  // 인덱스는 0부터 시작, 송전탑은 1부터 시작하므로 인접행렬 길이 +1
		
		for (int i = 0; i < wires.length; i++) {
			adj[wires[i][0]][wires[i][1]] = adj[wires[i][1]][wires[i][0]] = 1;  // 양방향
		}
		
		// 하나씩 끊어보기
		for (int i = 0; i < wires.length; i++) {
			int sNode = wires[i][0];
			int eNode = wires[i][1];
			
			// 연결된 송전탑 끊기
			adj[sNode][eNode] = 0;
			adj[eNode][sNode] = 0;
			
			// answer = Math.min(answer, bfs(adj, new boolean[n+1], 1, n));
			int nodeCnt = dfs(adj, new boolean[n+1], 1);
			answer = Math.min(answer, (int)Math.abs(nodeCnt-(n-nodeCnt)));
			
			// 끊었던 송전탑 연결
			adj[sNode][eNode] = 1;
			adj[eNode][sNode] = 1;
		}
		
		return answer;
	}

	private int dfs(int[][] adj, boolean[] v, int sNode) {
		int cnt = 1;  // 현재 송전탑
		v[sNode] = true;
		for (int i = 0; i < adj.length; i++) {
			if(!v[i] && adj[sNode][i] == 1) {
				cnt += dfs(adj, v, i);
			}
		}
//		System.out.println(Arrays.toString(v));
//		System.out.println(cnt);
		return cnt;
	}

	private int bfs(int[][] adj, boolean[] v, int sNode, int n) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(sNode);
		int cnt = 1;  // 개수 1 더하기(1번 송전탑)
		
		while(!q.isEmpty()) {
			int node = q.poll();
			v[node] = true;
			
			for (int i = 1; i < v.length; i++) {
				if(!v[i] && adj[node][i] == 1) {
					q.offer(i);
					cnt++;
				}
			}
		}
		
		return (int)Math.abs(cnt - (n - cnt));
	}
	
	

}
