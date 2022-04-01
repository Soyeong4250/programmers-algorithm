package Greedy;


public class boat {

	public static void main(String[] args) {  // 구명보트
//		int[] people = {70, 50, 80, 50};
//		int limit = 100;
		int[] people = {70, 80, 50};
		int limit = 100;
		
		System.out.println(solution(people, limit));
	}

	private static int solution(int[] people, int limit) {
		int answer = 0;
		
		for (int i = 0; i < people.length; i++) {
			boolean plus = false;
			for (int j = i+1; j < people.length; j++) {
				if(people[i] + people[j] <= limit) {
					plus = true;
					answer++;
					break;
				}
			}
			if(plus = false) {
				answer++;
			}
			
		}
		
		
//		System.out.println(Arrays.toString(check));
			
		return answer;
	}

}
