package lv1;

public class LookForAverage {  // 평균 구하기

	public static void main(String[] args) {
//		int[] arr = {1, 2, 3, 4};
		int[] arr = {5, 5};
		
		System.out.println(solution(arr));
	}
	
	private static double solution(int[] arr) {
		double answer = 0;
		
		for(int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		
		return answer/arr.length;
	}

}
