package lv3;

import java.util.Arrays;

public class Sequence {  // 연속 펄스 부분 수열의 합

	public static void main(String[] args) {
		Sequence main = new Sequence();
		
		int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
		System.out.println(main.solution(sequence));
	}

	private long solution(int[] sequence) {
		int[] sequence1 = new int[sequence.length];  // 1, -1, 1, -1, ...
		int[] sequence2 = new int[sequence.length];  // -1, 1, -1, 1, ...
		
		for (int i = 0; i < sequence.length; i++) {
			sequence1[i] = sequence[i] * (int)Math.pow(-1, i+2);
			sequence2[i] = sequence[i] * (int)Math.pow(-1, i+1);
		}
		
		System.out.println(Arrays.toString(sequence1));
		System.out.println(Arrays.toString(sequence2));
		
		long result1 = sequence1[0];
		long result2 = sequence2[0];
		long answer = Math.max(result1, result2);
		
		for (int i = 1; i < sequence.length; i++) {
			result1 = (result1 + sequence1[i]) < sequence1[i] ? sequence1[i] : (result1 + sequence1[i]);
			result2 = (result2 + sequence2[i]) < sequence2[i] ? sequence2[i] : (result2 + sequence2[i]);
//			System.out.println(result1);
//			System.out.println(result2);
			if(answer < result1) {
				answer = result1;
			}else if(answer < result2) {
				answer = result2;
			}
		}
		
		return answer;
	}

}
