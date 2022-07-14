package lv1;

import java.util.Arrays;

public class MakePrimeNumber {  // 소수 만들기

	public static void main(String[] args) {
//		int[] nums = {1, 2, 3, 4};
		int[] nums = {1, 2, 7, 6, 4};
		
		System.out.println(solution(nums));
	}

	private static int solution(int[] nums) {
		int answer = 0;
		
		answer = dfs(nums, new boolean[nums.length], 0, 0, 0);
		
		return answer;
	}
	
	private static int dfs(int[] nums, boolean[] v, int idx, int cnt, int sum) {
		if(cnt == 3) {
			System.out.println(Arrays.toString(v));
			System.out.println(sum);
			if(isPrime(sum)) {
				System.out.println(sum + "은 소수입니다");
				return 1;
			}
			return 0;
		}
		
		if(idx == nums.length) {
			return 0;
		}
		
		int p = 0;
		for (int i = idx; i < nums.length; i++) {
			if(v[i] == true) {
				continue;
			}
			v[i] = true;
			System.out.println("i = " + i);
			p += dfs(nums, v, i+1, cnt+1, sum+nums[i]);
			v[i] = false;
		}
		
		return p;
	}
	
	private static boolean isPrime(int n) {
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {  
			// 소수는 1부터 자기자신으로만 나누어지는 숫자이기 때문에 1부터 시작하며 제곱근 이후로는 곱셈의 숫자 순서만 바꿔 실행하기 때문에 제곱근까지만 반복문 실행
			if(n % i == 0) {  // 나누어 떨어지는 수가 있다면 소수x
				return false;
			}
		}
		return true;
	}

}
