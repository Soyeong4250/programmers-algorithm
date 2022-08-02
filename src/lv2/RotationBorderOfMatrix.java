package lv2;

import java.util.Arrays;

public class RotationBorderOfMatrix { // 행렬 테두리 회전하기

	public static void main(String[] args) {
//		int rows = 6;
//		int columns = 6;
//		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
//		int rows = 3;
//		int columns = 3;
//		int[][] queries = {{1, 1, 2, 2},{1, 2, 2, 3},{2, 1, 3, 2}, {2, 2, 3, 3}};
//		int rows = 100;
//		int columns = 97;
//		int[][] queries = {{1, 1, 100, 97}};
//		int rows = 3;
//		int columns = 4;
//		int[][] queries = {{1, 1, 2, 2}, {1, 2, 2, 3}, {1, 3, 2, 4}, {2, 3, 3, 4}};
		int rows = 3;
		int columns = 5;
		int[][] queries = {{1, 1, 2, 2}, {2, 3, 3, 4}, {1, 2, 3, 4}, {1, 1, 3, 4}, {2, 2, 3, 5}};

		System.out.println(solution(rows, columns, queries));
	}

	private static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		
		int[][] matrix = new int[rows+1][columns+1];
		
		// 배열 입력
		int idx = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				matrix[i][j] = idx;
				idx++;
			}
		}
		
		// 배열 확인
//		print(matrix);
		
		// 행렬 회전 
		int[] dr = {1, 0, -1, 0};  // 하 우 상 좌
		int[] dc = {0, 1, 0, -1};  // 하 우 상 좌
		
		for(int i=0; i<queries.length; i++) {
//			System.out.println("for문 시작");
			int d = 0;  // 방향 인덱스
			int sr = queries[i][0];
			int sc = queries[i][1];
			int first = matrix[sr][sc];
			int min = matrix[sr][sc];  // 가장 작은 수 초기화
//			System.out.println("min : " + min);

			while(d < 4) {
//				System.out.println("d : " + d);
				int nr = sr + dr[d];
				int nc = sc + dc[d];
				
				if(0 < nr && nr <= rows && 0 < nc && nc <= columns) {
					matrix[sr][sc] = matrix[nr][nc];
					min = Math.min(min, matrix[nr][nc]);
				}
				
				sr = nr;
				sc = nc;
				
				// 방향전환
				if((d==0 && nr == queries[i][2]) || (d==1 && nc == queries[i][3]) || (d == 2 && nr == queries[i][0]) || (d == 3 && nc == queries[i][1])) {
//					System.out.println("방향 전환");
					d++;
				}
//				print(matrix);
			}
//			System.out.println("while 끝");
			matrix[queries[i][0]][queries[i][1]+1] = first;
			answer[i] = min;
//			print(matrix);
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}
	
	private static void print(int[][] matrix) {
		for (int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}System.out.println();
		}
	}

}
