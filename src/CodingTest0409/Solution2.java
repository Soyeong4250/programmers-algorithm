package CodingTest0409;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class Solution2 { // 음성 인식 기술

	public static void main(String[] args) {
		String call = "abcabcdefabc";
//		String call = "abxdeydeabz";
//		String call = "abcabca";
//		String call = "ABCabcA";

		System.out.println("정답 : " + solution(call));

	}

	static List<Integer> cntList;
	private static String solution(String call) {
		String answer = "";
		
		call = call.toLowerCase();
		while(true) {
			System.out.println(call);
			System.out.println("함수로 들어갑니다");
			call = isPattern(call);

			if(call.length() >= 1) {
				answer = call;
			}
			if(Collections.frequency(cntList, 1) == cntList.size()) {
				System.out.println("1만 있어요");
				break;
			}
		}

		return answer;
	}

	private static String isPattern(String call) {
		cntList = new ArrayList<>();
		for (int i = 0; i < call.length()-1; i++) {
			for (int e = i+1; e < call.length(); e++) {
				
				char[] pattern = call.substring(i, e).toCharArray();  // 패턴 만들기
				
				System.out.println(Arrays.toString(pattern));
				int[] pi = new int [pattern.length];
				for (int j = 1, k=0; j < pattern.length; j++) {
					while(k > 0 && pattern[j] != pattern[k]) {
						k = pi[k-1];
					}
					
					if(pattern[j] == pattern[k]) {
						pi[j] = ++k;
					}
				}
				
				int cnt = 0;
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int j = 0, k=0; j < call.length(); ++j) {
					while(k>0 & call.charAt(j) != pattern[k]) {
						k = pi[k-1];
					}
					
					if(call.charAt(j) == pattern[k]) {
						if(k == pattern.length-1) {
							cnt++;
							list.add((j+1)-pattern.length);
							k=pi[k];
						}else {
							k++;
						}
					}
				}
				
				System.out.println("cnt " + cnt);
				cntList.add(cnt);
				System.out.println("cntList : " + cntList.toString());
				
				String prePattern = "";
				if(cnt>1) {
					for (int j = 0; j < pattern.length; j++) {
						prePattern += pattern[j];
					}
					System.out.println("패턴 : " + prePattern);
				}
				
				// 패턴이 위치한 위치 확인
				if(cnt>1) {
					System.out.println(list);
					call = call.replace(prePattern,"");
				}
			}
		}
		return call;
		
	}

}
