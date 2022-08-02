package lv2;

public class MaxAndMin {  // 최댓값과 최솟값

	public static void main(String[] args) {
		String s = "1 2 3 4";
//		String s = "-1-2-3-4";
//		String s = "-1-1";
		
		System.out.println(solution(s));
	}

	private static String solution(String s) {
		
		String[] arr = s.split(" ");
		
		int min = Integer.parseInt(arr[0]);
		int max = Integer.parseInt(arr[0]);

		for(int i=0; i<arr.length; i++) {
			int num = Integer.parseInt(arr[i]);
			min = Math.min(num, min);
			max = Math.max(num, max);
		}
		
		return min + " " + max;
	}

}
