package SkillCheck2;

public class Solution1 {

	public static void main(String[] args) {
		String s = "baabaa";
//		String s = "cdcd";
		
		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int answer = -1;
		String str = s;
		
		while(true) {
			boolean d = false;
			delete(str, d);
		}
		
		return answer;
	}

	private static void delete(String s, boolean d) {
		for (int i = 0; i < s.length()-1; i++) {
			String tmp = s.substring(i, i+2);
			if(tmp.charAt(0)==tmp.charAt(1)) {
				d = true;
				
				break;
			}
		}
	}

}
