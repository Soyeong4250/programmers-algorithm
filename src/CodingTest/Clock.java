package CodingTest;

public class Clock {

	public static void main(String[] args) {
		int n = 6;
		
		boolean clockwise = false;
		int[][] clock = {{1, 5, 4, 3, 2, 1},
						 {2, 6, 7, 8, 6, 5},
						 {3, 7, 9, 9, 8, 4},
						 {4, 8, 9, 9, 7, 3},
						 {5, 6, 7, 8, 6, 2},
						 {1, 2, 3, 4, 5, 1}};
		
		System.out.println(solution(n, clockwise));

	}

	private static int[][] solution(int n, boolean clockwise) {
		int[][] answer = {};
		int[] center = new int[2];
		if(n%2 == 0) { // n이 짝수일 때 중심은
			center[0] = n/2-1;
			center[1] = n/2-1;
		}else {
			center[0] = n/2+1;
			center[1] = n/2+1;
		}
		
		if (!clockwise) {
			
		}
		
		
		return answer;
	}

}
