package lv2;

import java.util.Arrays;

public class DifferentBits { // 2개 이하로 다른 비트

	public static void main(String[] args) {
		int[] numbers = { 2, 7 };
		System.out.println(solution(numbers));
	}

	private static long[] solution(int[] numbers) {
		long[] answer = new long[numbers.length];
		
		// 비트로 변환
		for(int i=0; i<numbers.length; i++) {
			String bytes1 = String.format("%08d", Integer.parseInt(Integer.toBinaryString(numbers[i])));
			int cnt = 0;
			
			int num = numbers[i]+1;
			while(true) {
				cnt = 0;
				String bytes2 = String.format("%08d", Integer.parseInt(Integer.toBinaryString(num)));
				for(int j = 0; j<8; j++) {
					if(bytes1.charAt(j) != bytes2.charAt(j)) {
						cnt++;
					}
				}
				
				if(cnt <= 2) {
					answer[i] = num;
					break;
				}else {
					num++;
				}
			}
		}

//		System.out.println(Arrays.toString(answer));
		
		return answer;
	}

}
