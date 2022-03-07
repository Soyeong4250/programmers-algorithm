package SampleQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class numberK { // K번째 수

	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		System.out.println(solution(array, commands));
	}

	private static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			List<Integer> list = new ArrayList<>();
			
			// 1. 리스트에 담기
			for (int j = commands[i][0]-1; j <= commands[i][1]-1; j++) {
				list.add(array[j]);
			}
			
			// 2. 정렬
			Collections.sort(list);
			
			// 4. k번째 수 StringBuilder에 담기
			answer[i] = list.get(commands[i][2] - 1);
		}
		
		// 확인
		System.out.println(Arrays.toString(answer));
		
		return answer;
	}

}
