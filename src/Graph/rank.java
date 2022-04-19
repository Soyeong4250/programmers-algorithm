package Graph;

import java.util.Arrays;

public class rank { // 순위

	public static void main(String[] args) {
		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };

		System.out.println(solution(n, results));
	}

	private static int solution(int n, int[][] results) {
		int answer = 0;
		int INF = 987654321;
		
		int[][] rank = new int[n+1][n+1];
		for (int i = 0; i < rank.length; i++) {
			Arrays.fill(rank[i], INF);			
		}
		
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < rank[i].length; j++) {
				if(i==j) {
					rank[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < results.length; i++) {
			rank[results[i][0]][results[i][1]] = 1;
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(rank[i][j] > rank[i][k] + rank[k][j]) {
						rank[i][j] = rank[i][k] + rank[k][j];
					}
				}
			}
		}
		
		// 확인
//		for (int i = 1; i < rank.length; i++) {
//			System.out.println(Arrays.toString(rank[i]));
//		}
		
		boolean[] flag = new boolean[n+1];
		Arrays.fill(flag, true);
		
		for (int i = 1; i < rank.length; i++) {
			for (int j = 1; j < rank.length; j++) {
				if(i==j) continue;
				if(rank[i][j]==INF && rank[j][i]==INF) {
					flag[i] = false;
					break;
				}
			}
		}
		
		for (int i = 1; i < flag.length; i++) {
			if(flag[i]) answer++;
		}
		
		return answer;
	}

}
