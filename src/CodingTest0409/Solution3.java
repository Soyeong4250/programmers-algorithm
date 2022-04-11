package CodingTest0409;

import java.util.HashMap;
import java.util.List;

public class Solution3 {

	public static void main(String[] args) {
//		String tstring = "this is {template} {template} is {state}";
//		String[][] variables = {{"template", "string"}, 
//								{"state", "changed"}};
		
		String tstring = "this is {template} {template} is {state}";
		String[][] variables = {{"template", "string"}, 
								{"state", "{template}"}};
		
//		String tstring = "this is {template} {template} is {state}";
//		String[][] variables = {{"template", "{state}"}, 
//								{"state", "{template}"}};
		
		System.out.println(solution(tstring, variables));
		
		
		

	}

	static List<String> list;
	static boolean[] circle;
	private static String solution(String tstring, String[][] variables) {
		String answer = "";
		
		// 1. 배열을 해쉬맵으로
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < variables.length; i++) {
			map.put(variables[i][0], variables[i][1]);
		}
		
		int cnt = 1;
		while(tstring.contains("{")) {
			for (int i = 0; i < variables.length; i++) {
				System.out.println(tstring);
				if(tstring.contains(variables[i][0])) {
					tstring = tstring.replace("{"+variables[i][0]+"}", variables[i][1]);
				}
				System.out.println(tstring);
			}
			
//			if(cnt < variables.length*9) {
//				break;
//			}
//			cnt++;
		}
		
		return answer;
	}
	

}
