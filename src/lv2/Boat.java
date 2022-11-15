package lv2;

import java.util.Arrays;

public class Boat {  // 구명보트

	public static void main(String[] args) {  
//		int[] people = {70, 50, 80, 50};
//		int limit = 100;
		int[] people = {70, 80, 50};
		int limit = 100;
		
		Boat boat = new Boat();
		System.out.println(boat.solution(people, limit));
	}
	
	
	private int solution(int[] people, int limit) {
		int answer = 1;
		
		Arrays.sort(people);
		
		int maxIdx = people.length-1;
		int minIdx = 0;
		int weight = people[maxIdx];
		
		while(minIdx < maxIdx) {
			System.out.println("minIdx = " + minIdx + ", maxIdx = " + maxIdx + ", weight = " + weight + ", answer = " + answer);
			if(weight + people[minIdx] <= limit) {
				weight += people[minIdx];
				minIdx++;
				continue;
			}
			answer++;
			maxIdx--;
			weight = people[maxIdx];
			System.out.println("weight 변경 = " + weight);
		}
		
		return answer;
	}

}
