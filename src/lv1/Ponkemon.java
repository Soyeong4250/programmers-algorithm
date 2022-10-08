package lv1;

import java.util.HashSet;

public class Poneketmon {  // 폰켓몬

	public static void main(String[] args) {
//		int[] nums = {3,1,2,3};
//		int[] nums = {3,3,3,2,2,4};
		int[] nums = {3,3,3,2,2,2};
		
		System.out.println(solution(nums));
	}

	private static int solution(int[] nums) {
		int answer = 0;
		
		int n = nums.length/2;
		HashSet<Integer> hash = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			hash.add(nums[i]);
		}
		
//		System.out.println(hash);
		
		if(hash.size() >= n) {
			answer = n;
		} else {
			answer = hash.size();
		}
		
		return answer;
		
	}

	/*private static int solution(int[] nums) {
		int answer = 0;
		
		int n = nums.length/2;
		HashMap<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hash.put(nums[i], hash.getOrDefault(nums[i], 0)+1);
		}
		
//		System.out.println(hash);
		
		if(hash.size() >= n) {
			answer = n;
		} else {
			answer = hash.size();
		}
		
		return answer;
	}*/
	
	

}
