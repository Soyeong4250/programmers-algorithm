package lv3;

public class Network { // 네트워크

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
//		int n = 3;
//		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

		System.out.println(solution(n, computers));
	}

	private static char[] solution(int n, int[][] computers) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*private static int solution(int n, int[][] computers) {
		int answer = 0;
	
		boolean[] v = new boolean[n];
		for (int i = 0; i < computers.length; i++) {
			if(!v[i]) {
				v = dfs(computers, v, i);
				answer++;
			}
		}
		
		return answer;
	}

	private static boolean[] dfs(int[][] computers, boolean[] v, int computer) {
		v[computer] = true;
		
		for (int i = 0; i < computers.length; i++) {
			if(computers[computer][i] == 1 && !v[i]) {
				dfs(computers, v, i);
			}
		}
		
		return v;
	}*/
	
	


}
