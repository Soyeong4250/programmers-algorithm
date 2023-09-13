package lv1;

import java.util.HashMap;

public class SecretCode { // 둘만의 암호

	public static void main(String[] args) {
		SecretCode main = new SecretCode();

		// happy
//		String s = "aukks";
//		String skip = "wbqd";
//		int index = 5;
		
		// o
//		String s = "a";
//		String skip = "bcdefhijk";
//		int index = 20;
		
		// bbbbb
//		String s = "zzzzz";
//		String skip = "a";
//		int index = 1;
		
		// 
//		String s = "zzzzzz";
//		String skip = "abcdefghijklmnopqrstuvwxy";
//		int index = 6;

		// n
		String s = "z";
		String skip = "abcdefghij";
		int index = 20;
		System.out.println(main.solution(s, skip, index));
	}

	private String solution(String s, String skip, int index) {
		HashMap<Integer, Character> alphabet = new HashMap<>();
		
		int idx = 1;
		for (int i = 0; i < 26; i++) {
			char ch = (char)(97+i);
			if(skip.contains(String.valueOf(ch))) continue;
			alphabet.put(idx, (char)(97+i));
			idx += 1;
		}
		
		System.out.println(alphabet);
		
		StringBuilder answer = new StringBuilder();
		int k;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			for (int key : alphabet.keySet()) {
				if(alphabet.get(key) == ch) {
					k = key;
					System.out.println(alphabet.size());
					answer.append(alphabet.get((k+index)%alphabet.size()==0 ? alphabet.size() : (k+index)%alphabet.size()));
					break;
				}
			}			
		}
		
		return answer.toString();
	}

}
