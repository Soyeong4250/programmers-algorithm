package lv2;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}
	
	private static int solution(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);
		
//		System.out.println(Arrays.toString(citations));
		
		for(int i=0; i<citations.length; i++) {
			if(citations[i] >= i+1) {
				answer = i+1;
				break;
			}
		}
		
		
		return answer;
	}

}
