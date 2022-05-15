package CodingTest0515;

import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {
		String[] replies = {"AFFDEFDEFDEEC", "ABABABABBCCEF", "FFFFFFFFFFFFF"};
		int n = 3;
		int k = 2;

//		String[] replies = {"AFFDEFDEFDEEC", "ABABABABBCCEF", "FFFFFFFFFFFFF", "FCBBBFCBBECBB"};
//		int n = 2;
//		int k = 4;
	
//		String[] replies = {"FFCCAAFCCAAA", "AAAABBBBCCCC", "ABCABCABCABC"};
//		int n = 4;
//		int k = 2;
	
//		String[] replies = {"FFCCAAFCCAAA", "AAAABBBBCCCC", "ABCABCABCABC"};
//		int n = 3;
//		int k = 3;
	
		System.out.println(solution(replies, n, k));
	}

	private static int[] solution(String[] replies, int n, int k) {
		int[] answer = new int[replies.length];
		Arrays.fill(answer, -1);
		
		for (int i = 0; i < replies.length; i++) {
			for(int m=n; m<replies[i].length(); m++) {
				for (int j = 0; j < replies[i].length()-m; j++) {
					String str = replies[i].replaceAll(replies[i].substring(j, j+m), "v");
					System.out.println(str);
					if(str.contains("vvv")) {
						answer[i] = 0;
						break;
					}
				}
			}
			
			
			for (int j = 0; j < answer.length; j++) {
				if(answer[j] == -1) {
					answer[j] = 1;
				}
			}
		}
		
		
		return answer;
	}

}
