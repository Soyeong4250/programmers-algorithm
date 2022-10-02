package lv3;

public class Network { // 네트워크

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
//		int n = 3;
//		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

		System.out.println(solution(n, computers));
	}

	private static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] v = new boolean[n]; // n 갯수만큼 boolean 배열을 만들고 모든 요소를 false로 초기화

		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				dfs(computers, i, v);
				answer++;
			}
		}

		return answer;
	}

	private static boolean[] dfs(int[][] computers, int idx, boolean[] v) {
		v[idx] = true;

	    for (int j = 0; j < computers.length; j++) {
	      if (idx != j && computers[idx][j] == 1 && v[j] == false) {
	        v = dfs(computers, j, v);
	      }
	    }
	    return v;
	}

}
