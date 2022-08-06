package lv2;

public class CheckingDistance {  // 거리두기 확인하기

	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
						 {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
						 {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
						 {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
						 {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(solution(places));
	}

	private static int[] solution(String[][] places) {
		int[] answer = new int[places.length];
		
		for (int i = 0; i < answer.length; i++) {
			String[][] map = new String[5][5];
			
			for (int j = 0; i < map.length; i++) {
					map[i] = places[i].
			}
		}
		
		return answer;
	}

}
