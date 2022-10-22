package lv2;

public class TargetNum {  // 타겟 넘버
//	static int cnt = 0;
	public static void main(String[] args) {
//		int[] numbers = {1, 1, 1, 1, 1};
//		int target = 3;
		int[] numbers = {4, 1, 2, 1};
		int target = 4;
		
		System.out.println(solution(numbers, target));
	}

	private static int solution(int[] numbers, int target) {
		
		return dfs(numbers, target, 0, 0);
	}

	private static int dfs(int[] numbers, int target, int idx, int sum) {
		// 기저 조건
		if(idx == numbers.length) { // 다 골랐다
			if(sum == target) {
				return 1;				
			}
			return 0;
			
		} 
		
		return dfs(numbers, target, idx + 1, sum+numbers[idx]) + dfs(numbers, target, idx + 1, sum-numbers[idx]);
		
	}
}
