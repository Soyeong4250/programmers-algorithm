package SampleQuestions;

import java.util.Arrays;
import java.util.Stack;

public class KakaoWinterInternship {  // 크레인 인형뽑기 게임

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		
		System.out.println(solution(board, moves));
	}

	private static int solution(int[][] board, int[] moves) {
		int answer = 0;  // 사라진 인형 수
		
		Stack<Integer> bucket = new Stack<>();
		
		for (int i = 0; i < moves.length; i++) {
			int select = 0;
			for (int j = 0; j < board.length; j++) {
				if(board[j][moves[i]-1] != 0) {
					select = board[j][moves[i]-1];
					board[j][moves[i]-1] = 0;
					break;
				}
			}
			
			
			if(!bucket.isEmpty() && select == bucket.peek()) {
				bucket.pop();
				answer+=2;
			}else if(select != 0){
				System.out.println(select + "push");
				bucket.push(select);
			}
			// 확인
			for (int j = 0; j < board.length; j++) {
				System.out.println(Arrays.toString(board[j]));
			}
			System.out.println("----------------------------------");
			System.out.println(bucket);
			System.out.println(answer);
			System.out.println("==================================");
		}
		
		return answer;
	}

}
