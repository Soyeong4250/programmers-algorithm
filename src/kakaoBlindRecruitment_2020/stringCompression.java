package kakaoBlindRecruitment_2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class stringCompression {

	public static void main(String[] args) {
		String s = "aabbaccc";
//		String s = "ababcdcdababcdcd";
//		String s = "abcabcdede";
//		String s = "abcabcabcabcdededededede";
//		String s = "xababcdcdababcdcd";

		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int answer = 987654321;
        
        for(int length = 1; length <= s.length(); length++) {
            StringBuilder sb = new StringBuilder();
            Queue<String> q = new LinkedList<>();
            for(int i = 0; i < s.length(); i+=length) {
                int start = i;
                int end = i + length;
                if(i+length > s.length()) {
                    end = s.length()-1;
                } 
                String str = s.substring(start, end);
                System.out.println(str);
                System.out.println("=======================");
                q.add(str);
            }
            
            int cnt = 1;
            while(!q.isEmpty()) {
                String str = q.poll();
                if(q.size() > 0 && q.peek().equals(str)) {
                    cnt++;
                } else {
                    if(cnt>1) {
                        sb.append(cnt);
                    }
                    cnt = 1;
                    sb.append(str);
                }
            }
            // System.out.println(sb.toString());
            if(Character.isDigit(sb.toString().charAt(0)) && answer > sb.length()) {
            	answer = sb.length();
            } else {
            	if(answer > sb.length()) {
                    answer = sb.length();
                }
            }
            System.out.println("======================");
            System.out.println(s.length());
            System.out.println(sb.toString());
            System.out.println(answer);
        }
        
        return answer;
	}

}
