package lv2;

import java.util.Arrays;

public class Joystick {  // 조이스틱

	public static void main(String[] args) {
//		String name = "JEROEN";
		String name = "JAN";
		
		System.out.println(solution(name));
	}

	private static int solution(String name) {
		int answer = 0;
		
		int[] dir = {-1, 1, -1, 1};  // 방향 : ^ v < >
		
		int[] result = new int[name.length()];  // 만들어야 하는 문자열 (아스키코드 담기)
		for(int i=0; i<result.length; i++) {
			result[i] = (int)name.charAt(i);
		}
		
//		System.out.println(Arrays.toString(result));
		
		int idx = 0;  
		while(true) {
			System.out.println("answer : " + answer);
			
			if(result[idx] == 65) {
				if(0 <= idx-2) {
					idx -= 2;
				} else {
					idx = result.length-1 + (idx-2);
				}
				answer ++;
				continue;
			}
			
			answer += Math.min(90-result[idx] + 1, result[idx] - 65);
			idx++;
			
			if(func(result, name)) {  // 동일 문자라면 멈추기
				break;
			}
			
//			System.out.println(result);
		}
		
		return answer;
	}

	private static boolean func(int[] result, String name) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<result.length; i++) {
			sb.append(result[i]-'0');
		}
		
		if(sb.toString().equals(name)) {
			return true;
		}
		
		return false;
	}

}
