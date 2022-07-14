package lv2;

public class targetNum {  // 타겟 넘버
	static int cnt = 0;
	public static void main(String[] args) {
//		int[] numbers = {1, 1, 1, 1, 1};
//		int target = 3;
		int[] numbers = {4, 1, 2, 1};
		int target = 4;
		
		System.out.println(solution(numbers, target));
	}

	private static int solution(int[] numbers, int target) {
		
		dfs(numbers, target, 0, 0);  // 배열, 만들 숫자, 인덱스, sum
		
		return cnt;
	}

	private static void dfs(int[] numbers, int target, int idx, int sum) {
		// 기저 조건
		if(idx == numbers.length) { // 다 골랐다
			if(sum == target) {
				cnt++;				
			}
			
		} else {
			dfs(numbers, target, idx + 1, sum+numbers[idx]);
			dfs(numbers, target, idx + 1, sum-numbers[idx]);
		}
		
	}
}
