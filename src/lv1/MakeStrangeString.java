package lv1;

public class MakeStrangeString {  // 이상한 문자 만들기
	
	public static void main(String[] args) {
//		String s = "try hello world";
		String s = "try hello javaaWorld";
		
		System.out.println(solution(s));
	}
	
	private static String solution(String s) {
		
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.substring(i, i+1).equals(" ")) {
				sb.append(" ");
				idx = 0; 
				continue;
			}
			
			if(idx%2 == 0) {
				sb.append(s.substring(i, i+1).toUpperCase());
			} else if(idx%2 != 0) {
				sb.append(s.substring(i, i+1).toLowerCase());
			}
			idx++;
		}
		
		return sb.toString();
	}
}
