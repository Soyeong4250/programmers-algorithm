package lv1;

import java.util.HashMap;

public class PlusAndCountOfDivisor { // 약수의 개수와 덧셈

	public static void main(String[] args) {
//		int left = 13;
//		int right = 17;
//		int left = 24;
//		int right = 27;
		int left = 1;
		int right = 10;

		System.out.println(solution(left, right));
	}

//	private static int solution(int left, int right) {
//		int answer = 0;
//		
//		for(int i = left; i <= right; i++) {
//			HashMap<Integer, Integer> divisor = new HashMap<>();
//			for(int j=1; j<=i; j++) {
//				if(i%j == 0) {
//					divisor.put(j, divisor.getOrDefault(j, 0) + 1);
//					divisor.put(i/j, divisor.getOrDefault(i/j, 0) + 1);
//				}
//			}
//			
////			System.out.println(divisor);
//			
//			if(divisor.size() % 2 == 0) {
////				System.out.println("+" + i);
//				answer += i;
//			} else {
////				System.out.println("-" + i);
//				answer -= i;
//			}
//			
//		}
//		
//		return answer;
//	}
	private static int solution(int left, int right) {
		int answer = 0;
		
		for(int i = left; i <= right; i++) {
			if(i % Math.sqrt(i) == 0) {
				answer -= i;
			} else {
				answer += i;
			}
			
		}
		
		return answer;
	}

}
