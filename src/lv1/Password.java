package lv1;

public class Password {  // 시저 암호

	public static void main(String[] args) {
//		String s = "AB";
//		int n = 1;
//		String s = "z";
//		int n = 1;
		String s = "a B z";
		int n = 4;
		
		System.out.println(solution(s, n));
	}
	
//	private static String solution(String s, int n) {
//		StringBuilder sb = new StringBuilder();
//		
//		for(int i=0; i<s.length(); i++) {
//			if(s.charAt(i) + n > 'z') {
//				sb.append((char)('a' + (n - ('z' - s.charAt(i)) - 1)));
//			}else if(s.charAt(i) <= 'Z' && s.charAt(i) + n > 'Z') {
//				sb.append((char)('A' + (n - ('Z' - s.charAt(i)) - 1)));
//			}else if(s.charAt(i) == ' ') {
//				sb.append(' ');
//			}else {
//				sb.append((char)(s.charAt(i) + n));
//			}
//		}
//		
//		return sb.toString();
//	}
	
	private static String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(Character.isLowerCase(ch)) {
				ch = (char)((ch - 'a' + n) % 26 + 'a');
			}else if(Character.isUpperCase(ch)){
				ch = (char)((ch - 'A' + n) % 26 + 'A');
			}
			sb.append(ch);
		}
		
		return sb.toString();
		
	}

}
