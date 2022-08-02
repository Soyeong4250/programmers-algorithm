package lv2;

import java.util.Arrays;

public class RotationBorderOfMatrix { // 행렬 테두리 회전하기

	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
//		int rows = 3;
//		int columns = 3;
//		int[][] queries = {{1, 1, 2, 2},{1, 2, 2, 3},{2, 1, 3, 2}, {2, 2, 3, 3}};
//		int rows = 100;
//		int columns = 97;
//		int[][] queries = {{1, 1, 100, 97}};

		System.out.println(solution(rows, columns, queries));
	}

	private static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		
		int[][] matrix = new int[rows][columns];
		
		// 배열 입력
		int idx = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = idx;
				idx++;
			}
		}
		
		// 배열 확인
//		print(matrix);
		
		// 행렬 회전
		int[] dr = {0, -1, 0, 1};  // 상 좌 하 우
		int[] dc = {-1, 0, 1, 0};  // 상 좌 하 우
		
		for(int i=0; i<queries.length; i++) {
			int min = matrix[queries[i][0]-1][queries[i][1]-1];  // 가장 작은 수 초기화
			
			int d = 0;  // 방향 인덱스
			while(d < 4) {
				
			}
			
		}
		
		return null;
	}
	
	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

}
