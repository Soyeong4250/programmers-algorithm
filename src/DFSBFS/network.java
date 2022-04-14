package DFSBFS;

import java.util.ArrayList;
import java.util.List;

public class network { // 네트워크

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
//		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

		System.out.println(solution(n, computers));

	}

	private static int solution(int n, int[][] computers) {
		int answer = 0;
				
		dfs(computers, new boolean[n]);
		
		
		return answer;
	}

	private static void dfs(int[][] computers, boolean[] v) {
		
		for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers.length; j++) {
				
			}
		}
	}

}
