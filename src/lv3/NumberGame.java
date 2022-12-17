package lv3;

import java.util.Arrays;

public class NumberGame {  // 숫자 게임

	public int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		
        int idx = B.length-1;
		for (int i = A.length-1; i >= 0; i--) {
			for (int j = idx; j >= 0; j--) {
				if(A[i] < B[j]) {
					answer++;
					A[i] = -1;
					B[j] = -1;
                    idx = j-1;
					break;
				}
			}
			/*print(A);
			print(B);
			System.out.println(answer);*/
		}
		return answer;
	}
	
	/*private void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}*/
	
	public static void main(String[] args) {
		NumberGame main = new NumberGame();
		
		int[] A = {5, 1, 3, 7};
		int[] B = {2, 2, 6, 8};
		
		System.out.println(main.solution(A, B));
	}

}
