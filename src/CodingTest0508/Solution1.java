package CodingTest0508;

import java.util.Arrays;

public class Solution1 {  // 25%

	public static void main(String[] args) {
//		int[][] atmos = {{80, 35}, {70, 38}, {100, 41}, {75,30}, {160,80}, {77, 29}, {181, 68}, {151, 76}};
//		int[][] atmos = {{140, 90}, {177, 75}, {95, 45}, {71,31}, {150,30}, {80, 35}, {72, 33}, {166, 81}, {151, 75}};
		int[][] atmos = {{30, 15}, {80, 35}};
		
		System.out.println(solution(atmos));
	}

	private static int solution(int[][] atmos) {
		int answer = 0;
		
		int[] mask = new int[atmos.length];  // 마스크 착용 기간
		
		// 미세먼지, 초미세먼지 농도 측정
		for(int i=0; i<atmos.length; i++) {
			for(int j=0; j<atmos[i].length; j++) {
				if(81 <= atmos[i][0] || 36 <= atmos[i][1]) {
					mask[i] = 1;
				}
				
				if(151 <= atmos[i][0] && 76 <= atmos[i][1]) {
					mask[i] = 4;
				}
			}
		}
		
//		System.out.println(Arrays.toString(mask));
		boolean use = false;
		for(int i=0; i<mask.length; i++) {
			if(use == true) {
				mask[i] = mask[i-1]+1;
			}
			
			if(mask[i] == 1) {
				use = true;
			}else if(mask[i] == 3) {
				use= false;
			}
			
		}
//		System.out.println(Arrays.toString(mask));
		for(int i=0; i<mask.length; i++) {
			if(mask[i] == 1 || mask[i] == 4) {
				answer++;
			}
		}
		
		return answer;
	}

}
