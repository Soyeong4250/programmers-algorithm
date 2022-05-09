package DFSBFS;

import java.util.HashMap;

public class network { // 네트워크

	public static void main(String[] args) {
//		int n = 3;  // 컴퓨터의 개수
//		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
//		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
//		int n = 4;
//		int[][] computers = {{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}};
//		int[][] computers = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
//		int[][] computers = {{1, 0, 1, 0}, {0, 1, 0, 0}, {1, 0, 1, 0}, {0, 0, 0, 1}};
//		int[][] computers = {{1, 1, 1, 0}, {1, 1, 0, 0}, {1, 0, 1, 1}, {0, 0, 1, 1}};

		int n = 5;
//		int[][] computers = {{1, 0, 0, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
		int[][] computers = {{1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
		
		
		System.out.println(solution(n, computers));

	}
	static int[] parents;
	private static int solution(int n, int[][] computers) {
		int answer = 0;
		parents = new int[n];
		
		// 첫 부모는 자기 자신
		for(int i=0; i<parents.length; i++) {
			parents[i] = i;
		}
		
		// union
		for (int i = 0; i < computers.length; i++) {
			for (int j = i; j < computers[i].length; j++) {
				if(computers[i][j] == 1) {  // 1이라면 연결되어 있음
					union(i, j);
				}
			}
		}
		
		// 부모 개수 구하기
		HashMap<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < parents.length; i++) {
			hash.put(parents[i], hash.getOrDefault(parents[i], 0)+1);
		}
		answer = hash.size();
		return answer;
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		// 같은 부모를 가지고 있지 않다면
		if(x != y) {
			if(x < y) parents[y] = x;
			else parents[x] = y;
		}
		
	}

	private static int find(int x) {
		// 부모 배열의 부모가 자기 자신이라면 return
		if(x == parents[x]) return x;
		// 부모 배열의 부모가 자기 자신이 아니라면 parents[x]의 부모 찾기
		else return parents[x] = find(parents[x]);
	}
	
}
