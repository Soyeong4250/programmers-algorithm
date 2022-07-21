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
        max = "0";
        permutation(numbers, new boolean[numbers.length], "", 0);

        return max;
    }
    
    static String max;
    private static void permutation(int[] numbers, boolean[] v, String num, int cnt) {
        if(cnt == numbers.length) {
            if(Integer.parseInt(max) < Integer.parseInt(num)) {
                max = num;
            }
            return;
        }
        
        for(int i=0; i<numbers.length; i++) {
         if(!v[i]) {
             v[i] = true;
             permutation(numbers, v, num + String.valueOf(numbers[i]), cnt+1);
             v[i] = false;
          }
        }
    }

}
