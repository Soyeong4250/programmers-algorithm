package Search;

import java.util.ArrayList;
import java.util.List;

public class primeNumber {

	public static void main(String[] args) {
		String numbers = "17";
		System.out.println(solution(numbers));

	}

	private static int solution(String numbers) {
		int answer = 0;  // 소수의 개수

		String[] arr = numbers.split("");
		List<String> list = new ArrayList<>();  // 조합 저장할 리스트
		
		// 확인
		for (String s : arr) {
			System.out.println(s);
		}
		
		StringBuilder sb = new StringBuilder();
		powerSet(arr, new boolean[arr.length], sb);
		
		return answer;
	}

	private static void powerSet(String[] arr, boolean[] v, StringBuilder sb) {
		
		if(sb.length() == arr.length) {
			
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			
			if(v[i]) continue;
			
			sb.append(arr[i]);
			v[i] = true;
			powerSet(arr, v, sb);
			v[i] = false;
			sb = sb.delete(0, sb.length()-1);
		}
	}
}
