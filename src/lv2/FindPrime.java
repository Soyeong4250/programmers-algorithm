package lv2;

import java.util.HashSet;

public class FindPrime {  // 소수 찾기

	public static void main(String[] args) {
		String numbers = "17";
//		String numbers = "011";
		
		System.out.println(solution(numbers));
	}

	private static int solution(String numbers) {
		String[] num = new String[numbers.length()];
		for (int i = 0; i < numbers.length(); i++) {
			num[i] = numbers.substring(i, i+1);
		}
		
		hash = new HashSet<>();
		// 자를 문자열 길이를 늘려가며 소수 판별
		for(int i = 1; i <= numbers.length(); i++) {
			Combination(num, new boolean[numbers.length()], "", i);
		}
		
		return hash.size(); 
	}
	
	static HashSet<Integer> hash;
	private static void Combination(String[] num, boolean[] v, String str, int lng) {
		if(str.length() == lng) {
			if(isPrime(Integer.parseInt(str))) {  // 소수판별
				hash.add(Integer.parseInt(str));
				
				return;
			}
		}
		
		for(int i=0; i<num.length; i++) {
			if(v[i]) continue;
			v[i] = true;
			Combination(num, v, str + num[i], lng);
			v[i] = false;
		}
	}

	private static boolean isPrime(int n) {
		if(n <= 1) return false;
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {  // 1과 자신외에 나누어 떨어지는 수가 있다면
				return false;  // 소수 x
			}
		}
		
		return true;
	}
	
	
}
