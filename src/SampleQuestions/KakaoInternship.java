package SampleQuestions;

public class KakaoInternship { // 키패드 누르기
	static class Location {
		int lx;
		int ly;
		int rx;
		int ry;

		public Location(int lx, int ly, int rx, int ry) {
			super();
			this.lx = lx;
			this.ly = ly;
			this.rx = rx;
			this.ry = ry;
		}
	}

	public static void main(String[] args) {
		// 1
		// int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		// String hand = "right";
		
		// 2
//		 int[] numbers = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
//		 String hand = "left";
		
		// 3
		 int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		 String hand = "right";
		
		
		System.out.println(solution(numbers, hand));
	}

	private static String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();
		Location loc = new Location(1, 4, 3, 4);

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0)
				numbers[i] = 11;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer.append("L");
				loc.lx = 1;
				loc.ly = numbers[i] / 3 + 1;
				System.out.println("왼손의 위치" + loc.lx + ", " +loc.ly + " 오른손의 위치" + loc.rx + ", " + loc.ry);
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer.append("R");
				loc.rx = 3;
				loc.ry = numbers[i] / 3;
				System.out.println("왼손의 위치" + loc.lx + ", " +loc.ly + " 오른손의 위치" + loc.rx + ", " + loc.ry);
			} else {
				int distanceL = Math.abs(2 - loc.lx) + Math.abs((numbers[i] / 3 + 1) - loc.ly);
				int distanceR = Math.abs(2 - loc.rx) + Math.abs((numbers[i] / 3 + 1) - loc.ry);
				if (distanceL < distanceR || (distanceL == distanceR && hand.equals("left"))) {
					answer.append("L");
					loc.lx = 2;
					loc.ly = numbers[i]/3 + 1;
					System.out.println("왼손의 위치" + loc.lx + ", " +loc.ly + " 오른손의 위치" + loc.rx + ", " + loc.ry);
				} else if (distanceL > distanceR || (distanceL == distanceR && hand.equals("right"))) {
					answer.append("R");
					loc.rx = 2;
					loc.ry = numbers[i]/3 + 1;
					System.out.println("왼손의 위치" + loc.lx + ", " +loc.ly + " 오른손의 위치" + loc.rx + ", " + loc.ry);
				}
			}
		}

		return answer.toString();
	}

}
