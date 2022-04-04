package CodingTest0402;

public class Solution3 {
	
	static class Node {  // 사용한 노드 담기
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		int n = 8;
		int[][]edges = {{0,1},{1,2},{2,3},{4,0},{5,1},{6,1},{7,2},{7,3},{4,5},{5,6},{6,7}};
		int k = 4;
		int a = 0;
		int b = 0;
		
		System.out.println(solution(n, edges, k, a, b));
	
	}

	private static int solution(int n, int[][] edges, int k, int a, int b) {
		int answer = -1;
		
		int[][] edge = new int[n][n];
		for (int i = 0; i < edges.length; i++) {  // 노드 정보
			edge[edges[i][0]][edges[i][1]] = edge[edges[i][1]][edges[i][0]] = 1;
		}
		
		func(edge, k, a, b, new boolean[n]);
		
		
		return answer;
	}

	private static void func(int[][] edge, int k, int a, int b, boolean v[]) {
		v[a] = true;
		
		if(k == 0) {  // 가중치 초과
			return;
		}
		
		if(a == b) {  // 도착했다
			return;
		}
		
		
		for (int i = 0; i < edge[a].length; i++) {
			if(!v[i] & edge[a][i] == 1) {  // 방문하지 않았고 연결되어 있다.
				
				func(edge, k--, i, b, v);
			}
		}
	}

}
