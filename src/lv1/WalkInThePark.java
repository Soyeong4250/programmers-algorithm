package lv1;

public class WalkInThePark { // 공원 산책

	public static void main(String[] args) {
		WalkInThePark main = new WalkInThePark();

		// [2, 1]
//		String[] park = { "SOO", "OOO", "OOO" };
//		String[] routes = { "E 2", "S 2", "W 1" };

		// [0, 1]
//		String[] park = {"SOO","OXX","OOO"};
//		String[] routes = {"E 2","S 2","W 1"};

		// [0, 0]
		String[] park = {"OSO","OOO","OXO","OOO"};
		String[] routes = {"E 2","S 3","W 1"};

		System.out.println(Arrays.toString(main.solution(park, routes)));
	}

	private int[] solution(String[] park, String[] routes) {
		
		// 시작 인덱스 구하기
		int sr = 0;
		int sc = 0;
		
		L : for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[i].length(); j++) {
				if(park[i].substring(j, j+1).equals("S")) {
					sr = i;
					sc = j;
					break L;
				}
			}
		}
		
		
		// 이동하기
		int nr;
		int nc;
		
		for (int i = 0; i < routes.length; i++) {
			nr = sr;
			nc = sc;
			String op = routes[i].substring(0, 1);  // 방향
			int n = Integer.parseInt(routes[i].substring(2));  // 이동 칸수

			System.out.println("nr = " + nr + ", nc = " + nc);
			
			if(op.equals("N")) {
				for (int j = 1; j <= n; j++) {
					nr -= 1;
					if(!move(park, nr, nc)) {
						System.out.println("1 이동 못함");
						nr = sr;
						break;
					}
				}
			} else if (op.equals("S")) {
				for (int j = 1; j <= n; j++) {
					nr += 1;
					if(!move(park, nr, nc)) {
						System.out.println("2 이동 못함");
						nr = sr;
						break;
					}
				}
			} else if (op.equals("W")) {
				for (int j = 1; j <= n; j++) {
					nc -= 1;
					if(!move(park, nr, nc)) {
						System.out.println("3 이동 못함");
						nc = sc;
						break;
					}
				}
			} else if (op.equals("E")) {
				for (int j = 1; j <= n; j++) {
					nc += 1;
					if(!move(park, nr, nc)) {
						System.out.println("4 이동 못함");
						nc = sc;
						break;
					}
				}
			}
			
			sr = nr;
			sc = nc;
			System.out.println("sr = " + sr + ", sc = " + sc);
			
		}
		
		
		return new int[]{sr, sc};
	}

	private boolean move(String[] park, int nr, int nc) {
		
		// 공원 안에 있다면 & 장애물이 아니라면 이동
		if(0 <= nr && nr < park.length && 0 <= nc && nc < park[0].length() && park[nr].charAt(nc) != 'X') {
			System.out.println("nr = " + nr + ", nc = " + nc + ", park[nr].charAt(nc) = " + park[nr].charAt(nc));
			return true;
		}
		
		return false;
	}

}
