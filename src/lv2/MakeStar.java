package lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakeStar {  // 교점에 별 만들기

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
//		int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
//		int[][] line = {{1, -1, 0}, {2, -1, 0}};
//		int[][] line = {{1, -1, 0}, {2, -1, 0}, {4, -1, 0}};

		System.out.println(solution(line));
	}
	
	private String solution(int[][] line) {
		String[] answer = {};
		
		
		
		return answer;
	}

}
