package SampleQuestions;


public class kakaoInternship1 {  // 2021 카카오 채용연계형 인턴십 - 거리두기 확인하기

	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
				             {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
				             {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, 
				             {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
				             {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		solve(places);
	}

	private static void solve(String[][] places) {
			
		for (int i = 0; i < places.length; i++) {  // 대기실 개수 5
			int[][] arr = new int[5][5];
			for (int j = 0; j < places[i].length; j++) {  // 대기실 세로 길이 5
				for (int k = 0; k < 5; k++) {  // 각 원소 담기
					System.out.println("들어왔당");
					char str = places[i][j].charAt(k);
					if(str == 'P') {
						arr[j][k] = 1;
					}else if(str == 'O') {
						arr[j][k] = 0;
					}else if(str == 'X') {
						arr[j][k] = -1;
					}
					
				}
			}
			// 확인
			print(arr);
		}
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
	}

}
