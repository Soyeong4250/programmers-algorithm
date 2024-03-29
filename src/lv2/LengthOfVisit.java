package lv2;

public class LengthOfVisit { // 방문 길이

	public static void main(String[] args) {
		LengthOfVisit main = new LengthOfVisit();

		// 7
		String dirs = "ULURRDLLU";

		// 7
//		String dirs = "LULLLLLLU";

		System.out.println(main.solution(dirs));
	}

	private int solution(String dirs) {
		int answer = 0;
		
		boolean[][][] visit = new boolean[11][11][4];
		
		int sr = 0;
		int sc = 0;
//		visit[sr][sc] = true;  // 원점 방문 체크
		
		for (int i = 0; i < dirs.length(); i++) {
			int nr = sr;
			int nc = sc;
			System.out.println("nr = " + nr + ", nc = " + nc + ", answer = " + answer);
			if(dirs.charAt(i)=='U') {
				nr -= 1;
			} else if(dirs.charAt(i)=='D') {
				nr += 1;
			} else if(dirs.charAt(i)=='R') {
				nc += 1;
			} else if(dirs.charAt(i)=='L') {
				nc -= 1;
			}
			if(isMove(nr, nc, visit)) {
				System.out.println("move");
				if (!visit[sr][sc]) {
					answer += 1;
					visit[sr][sc] = true;
				} else if(!visit[nr][nc]) {
					answer += 1;
				}
				sr = nr;
				sc = nc;
			}
			System.out.printl+++n("sr = " + sr + ", sc = " + sc + ", answer = " + answer);
		}
		
		return answer;
	}

	private boolean isMove(int nr, int nc, boolean[][] visit) {
		if(-5 > nr || nr > 5 || -5 > nc || nc > 5) {
			return false;
		}
		
		return true;
	}

}
