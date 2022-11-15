package lv2;

import java.util.Arrays;

public class Boat {  // 구명보트

	public static void main(String[] args) {  
//		int[] people = {70, 50, 80, 50};
//		int limit = 100;
//		int[] people = {70, 80, 50};
//		int limit = 100;
		int[] people = {30, 40, 50, 60};
		int limit = 100;
		
		Boat boat = new Boat();
		System.out.println(boat.solution(people, limit));
	}
	
	
	private int solution(int[] people, int limit) {
		int answer = 0;
		
		Arrays.sort(people);
		
		int maxIdx = people.length-1;
		int minIdx = 0;
		
		while(minIdx <= maxIdx) {
			answer++;
			System.out.println("minIdx = " + minIdx + ", maxIdx = " + maxIdx + ", answer = " + answer);
			if(people[maxIdx] + people[minIdx] <= limit) {
				System.out.println("people[minIdx] = " + people[minIdx]);
				minIdx++;
				maxIdx--;
			} else {
				maxIdx--;
			}
		}
		
		return answer;
	}

}
