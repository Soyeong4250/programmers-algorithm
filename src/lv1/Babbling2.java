package lv1;

public class Babbling2 { // 옹알이 2

	public static void main(String[] args) {
		Babbling2 main = new Babbling2();

		// 1
//		String[] babbling = {"aya", "yee", "u", "maa"};
		
		// 2
		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
	
		System.out.println(main.solution(babbling));
	}

	private int solution(String[] babbling) {
		int answer = 0;
		
		String[] word = {"aya", "ye", "woo", "ma"};
		
		for (int i = 0; i < babbling.length; i++) {
			String str = babbling[i];
			System.out.println(babbling[i]);
			
			String prev = "";
			int idx = 0;
			while(!str.isEmpty()) {
				if(str.startsWith(word[idx])) {
					System.out.println(word[idx] + "로 시작");
					if(prev.equals(word[idx])) break;
					System.out.println("replace");
					str = str.replaceFirst(word[idx], "");
					prev = word[idx];
					idx = 0;
				} else {
					idx += 1;
				}
				
				if(idx >= 4) break;
				System.out.println("현재 문자 = " + str);
			}
			
			if(str.isEmpty()) {
				System.out.println("발음할 수 있는 단어 추가 = " + babbling[i]);
				answer += 1;
			}
			System.out.println("answer = " + answer);
		}
		
		return answer;
	}

}
