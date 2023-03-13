package lv3;

import java.util.Arrays;

public class LinkIsland { // 섬 연결하기

	public static void main(String[] args) {
		LinkIsland main = new LinkIsland();

//		int n = 4;
//		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		int n = 5;
		int[][] costs = { { 0, 1, 1 }, { 1, 2, 4 }, { 1, 3, 1 }, { 2, 3, 2 }, { 3, 4, 3 } };
		System.out.println(main.solution(n, costs));
	}

	private int solution(int n, int[][] costs) {
		Arrays.sort(costs, (s1, s2) -> s1[2] == s2[2] ? s1[0] - s2[0] : s1[2] - s2[2]);
		
		// 정렬 확인
//		for (int i = 0; i < costs.length; i++) {
//			System.out.println(Arrays.toString(costs[i]));
//		}
		
		int[] parent = new int[n];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		int answer = 0;
		for (int i = 0; i < costs.length; i++) {
			if(parent[costs[i][0]] != parent[costs[i][1]]) {
				answer += costs[i][2];
//				System.out.println(costs[i][2]);
				if(parent[costs[i][0]] < parent[costs[i][1]]) {
					parent[costs[i][1]] = parent[costs[i][0]];
				} else {
					parent[costs[i][0]] = parent[costs[i][1]];
				}
			}
//			System.out.println(Arrays.toString(parent));
		}
		
		return answer;
	}

}
