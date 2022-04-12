package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class farthestNode { // 가장 먼 노드

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		System.out.println(solution(n, edge));
	}

	private static int solution(int n, int[][] edge) {
		int answer = 0;
		
		boolean []v = new boolean[n+1];  // 방문체크
		List<ArrayList<Integer>> node = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			node.add(i, new ArrayList<>());
		}
		
		for (int i = 0; i < edge.length; i++) {  // 양방향
			node.get(edge[i][0]).add(edge[i][1]);
			node.get(edge[i][1]).add(edge[i][0]);
		}
		
		answer = bfs(v, node);
		
		return answer;
	}

	private static int bfs(boolean[] v, List<ArrayList<Integer>> node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		v[1] = true;
		
		int cnt = 0;
		while(true) {
			Queue<Integer> tmp = new LinkedList<>();  // 임시 큐
			
			// bfs
			while(!q.isEmpty()) {
				int cur = q.poll();  // 정점 하나 뽑기
				for (int ver:node.get(cur)) {
					if(!v[ver]) {
						tmp.add(ver);
						v[ver] = true;
					}
				}
			}
			
			if(tmp.isEmpty()) break;
			q.addAll(tmp);
			cnt = tmp.size();
		}
		
		return cnt;
	}

}
