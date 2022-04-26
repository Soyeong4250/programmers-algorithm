package SummerWinterCoding_2018;

import java.util.Arrays;

public class delivery { // 배달

	public static void main(String[] args) {
//		int N = 5;
//		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
//		int K = 3;

		int N = 6;
		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int K = 4;

		System.out.println(solution(N, road, K));
	}

	private static int solution(int N, int[][] road, int K) {
		int answer = 0;
		int INF = 987654321;
		
		int[] dist = new int[N+1];
		boolean[] v = new boolean[N+1];
		int[][] adj = new int[N+1][N+1];
		for (int i = 0; i < adj.length; i++) {
			Arrays.fill(adj[i], INF);
		}
		
		for (int i = 0; i < road.length; i++) {  // 양방향
			if(adj[road[i][0]][road[i][1]] == INF) {
				adj[road[i][0]][road[i][1]] = road[i][2];
				adj[road[i][1]][road[i][0]] = road[i][2];
			}else {  // 두가지 경로 중 짧은 경로로 선택
				adj[road[i][0]][road[i][1]] = Math.min(adj[road[i][0]][road[i][1]], road[i][2]);
				adj[road[i][1]][road[i][0]] = Math.min(adj[road[i][1]][road[i][0]], road[i][2]);
			}
		}
		
		// 확인
//		for (int i = 0; i < adj.length; i++) {
//			System.out.println(Arrays.toString(adj[i]));
//		}System.out.println();
		
		// 초기 거리 입력
		Arrays.fill(dist, INF);  // 최소거리 비교하기 위해
//		for (int i = 1; i < dist.length; i++) {
//			dist[i] = adj[1][i];
//		}
		dist[1] = 0;
		
		int cnt = 0;
		while(true) {
			int min = INF;
			int tmp = 0;  // 연결되어 있는 번호

			cnt++;
			// 시작점에서부터 최소 거리 찾기 (탐색)
			for (int i = 1; i < v.length; i++) {
				if(!v[i] && dist[i] < min) {
					min = dist[i];
					tmp = i;
				};
			}
			v[tmp] = true;
			
			// 최소거리인 지점에서 다른 지점까지의 거리 구하기
			for (int j = 1; j < adj.length; j++) {
				if(!v[j] && adj[tmp][j] != INF && dist[j] > dist[tmp] + adj[tmp][j]) {
					dist[j] = dist[tmp] + adj[tmp][j];  // 최신화
				}
				System.out.println(tmp + ", " + j + ": " + dist[j]);
			}
			
			if(cnt == N-1) {
				break;
			}
			
		}
		
		// dist 확인
		System.out.println(Arrays.toString(dist));
		
		// 거리가 K이하인 값 개수 더하기
		for (int i = 1; i < dist.length; i++) {
			if(dist[i] <= K) {
				answer++;
			}
		}
		
		return answer;
	}

}
