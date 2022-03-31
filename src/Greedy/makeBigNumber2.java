package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class makeBigNumber2 { // 큰 수 만들기
	
	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
//		String number = "1231234";
//		int k = 3;
//		String number = "4177252841";
//		int k = 4;

		System.out.println(solution(number, k));
	}

	private static String solution(String number, int k) {
		String answer = "";
		k = number.length()-k;
		Set<Integer> set = new HashSet<>();
		
		char[] ch = number.toCharArray();
		
		Comb(ch, new boolean[ch.length], 0, "", k, set);
		
//		System.out.println(list);
		List list =  new ArrayList<>(set);
		Collections.sort(list);
//		System.out.println(list.get(list.size()-1));
		answer = list.get(list.size()-1).toString();
		
		return answer;
	}

	private static void Comb(char[] ch, boolean[] v, int s, String n, int k, Set<Integer> set) {
		if(k == 0) {  // 다 골랐다
//			System.out.println("다골라서 " + n);
			set.add(Integer.parseInt(n));
			return;
		}
		
		if(s == ch.length) {
//			System.out.println("인덱스 끝" + n);
			return;
		}
		
		for (int i = s; i < ch.length; i++) {
			v[i] = true;
			Comb(ch, v, i+1, n+ch[i], k-1, set);
			
//			v[i] = false;
			Comb(ch, v, i+1, n, k, set);
		}
		
	}

}
