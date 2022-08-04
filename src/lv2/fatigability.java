package lv2;

public class fatigability { // 피로도

	public static void main(String[] args) {
//		int k = 80;
//		int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };

//		int k = 30;
//		int[][] dungeons = { { 20, 20 }, { 50, 40 }, { 30, 10 } };

//		int k = 40;
//		int[][] dungeons = { { 40, 20 }, { 10, 10 }, { 10, 10 }, { 10, 10 }, { 10, 10 } };

		int k = 5000;
		int[][] dungeons = { { 1000, 1000 }, { 1000, 800 } ,{ 900, 900 }, {1500, 1500}, { 200, 40 }, { 1500, 1000 }};
		
		
		System.out.println(solution(k, dungeons));
	}

	private static int solution(int k, int[][] dungeons) {
		// DFS 실행하기
		DFS(dungeons, new boolean[dungeons.length], k, 0);

		return max;
	}

	static int max = -1; // 최대 개수 담기

	private static void DFS(int[][] dungeons, boolean[] v, int k, int cnt) {

		for (int i = 0; i < dungeons.length; i++) {
			if (v[i]) continue; // 이미 탐험한 던전이라면 continue;
			// 방문하지 않은 던전 탐험
			if(k >= dungeons[i][0]) {
//				System.out.println(i + "던전 탐험");
				v[i] = true; // 던전 탐험
				DFS(dungeons, v, k - dungeons[i][1], cnt + 1);
//				System.out.println(i + "던전 탐험 취소");
				v[i] = false; // 탐험했던 던전 취소
			}
		}
		
		max = Math.max(max, cnt);
		return;
	}

}
