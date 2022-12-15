package lv2;

import java.util.Arrays;

public class Delivery {  // 배달

	private int solution(int N, int[][]road, int K) {
		final int INF = 987654321;

		int answer = 0;
		
		int[] dist = new int[N+1];
		int[][] adj = new int[N+1][N+1];
		boolean[] v = new boolean[N+1];
		
		//  양방향 거리 체크
		for (int i = 1; i < adj.length; i++) {
			Arrays.fill(adj[i], INF);
			adj[i][i] = 0;
		}
		for (int i = 0; i < road.length; i++) {
			if(adj[road[i][0]][road[i][1]] == INF) {
				adj[road[i][0]][road[i][1]] = road[i][2];
				adj[road[i][1]][road[i][0]] = road[i][2];
			} else {
				adj[road[i][0]][road[i][1]] = Math.min(adj[road[i][0]][road[i][1]], road[i][2]);
				adj[road[i][1]][road[i][0]] = Math.min(adj[road[i][1]][road[i][0]], road[i][2]);
			}
		}
		
		/*for (int i = 1; i < adj.length; i++) {
			System.out.println(Arrays.toString(adj[i]));
		}*/
		
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		int cnt = 0;
		while(cnt < N-1) {
//			System.out.println("while문");
			int min = INF;
			int node = 0;
			
			cnt++;
			for (int i = 1; i < dist.length; i++) {
				if(!v[i] && dist[i] < min) {
					min = dist[i];
					node = i;
				}
			}
			v[node] = true;
//			System.out.println(Arrays.toString(dist));
			
			
			for (int i = 1; i < adj.length; i++) {
				if(!v[i] && adj[node][i] != INF && dist[i] > dist[node] + adj[node][i]) {
					dist[i] = dist[node] + adj[node][i];
				}
			}
//			System.out.println(Arrays.toString(dist));
		}
		
		for (int i = 1; i < dist.length; i++) {
			if(dist[i] <= K) {
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Delivery delivery = new Delivery();
		
		/*int N = 5;
		int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
		int K = 3*/;
		int N = 6;
		int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
		int K = 4;
		
		System.out.println(delivery.solution(N, road, K));
	}

}
