package lv2;

import java.util.Arrays;
import java.util.Comparator;

public class MaxNumber {  // 가장 큰 수

	public static void main(String[] args) {
//		int[] numbers = {6, 10, 2};
		int[] numbers = {3, 30, 34, 5, 9};
		
		System.out.println(solution(numbers));
	}
	
    private static String solution(int[] numbers) {
    	String[] arr = new String[numbers.length];
    	
    	for (int i = 0; i < arr.length; i++) {
			arr[i] = String.valueOf(numbers[i]);
		}
    	
    	Arrays.sort(arr, new Comparator<String>() {
    		@Override
    		public int compare(String o1, String o2) {
    			return ((o2+o1).compareTo(o1+o2));
    		}
    	});
    	
//    	System.out.println(Arrays.toString(arr));
    	if(arr[0].equals("0")) {
    		return "0";
    	}
    	
    	String answer = "";
    	for(String str:arr) {
    		answer += str;
    	}
    	return answer;
    }

}
