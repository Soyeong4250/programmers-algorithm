package lv1;

public class CorrectBracket {  // 올바른 괄호

	public static void main(String[] args) {
//		String s = "()()";
//		String s = "(())()";
		String s = ")()(";
//		String s = "(()(";
		
		System.out.println(solution(s));
	}
	
	private static boolean solution(String s) {
		boolean answer = true;

		int result = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
            	result += 1;
            } else {
            	result -= 1;
            }
        	
        	if(result == -1) {
            	answer = false;
            	break;
            }
        }
        
        if(result != 0) {
        	answer = false;
        }

        return answer;
	}

}
