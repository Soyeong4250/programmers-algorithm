package lv1;

public class MinimumRectangle { // 최소 직사각형

	public static void main(String[] args) {
//		int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
//		int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
		int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};

		System.out.println(solution(sizes));
	}

	private static int solution(int[][] sizes) {
		int answer = 0;
		
		int width = 0;  // 작은 수 담기
		int height = 0;  // 큰 수 담기
		for (int i = 0; i < sizes.length; i++) {
			if(sizes[i][0] <= sizes[i][1]) {
				width = Math.max(width, sizes[i][0]);
				height = Math.max(height, sizes[i][1]);
			}else {
				width = Math.max(width, sizes[i][1]);
				height = Math.max(height, sizes[i][0]);
			}
		}
		
		System.out.println(width + ", " + height);
		answer = width * height;
		return answer;
	}

}
