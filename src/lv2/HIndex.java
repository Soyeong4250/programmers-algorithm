package lv2;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
//		int[] citations = {3, 0, 6, 1, 5};
		int[] citations = {9, 2, 5, 1};
//		int[] citations = {6, 5, 5, 5, 3, 2, 1, 0};
//		int[] citations = {0, 1};
		System.out.println(solution(citations));
	}
	
	private static int solution(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);
		System.out.println(Arrays.toString(citations));
		
		for (int i = 0; i < citations.length; i++) {
			int hIdx = citations.length - i;
			
			if(citations[i] >= hIdx) {
				answer = hIdx;
				break;
			}
			
		}
		
		
		return answer;
	}

}
