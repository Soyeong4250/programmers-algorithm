package KakaoWinterIntership_2019;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class badUser {

	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "abc1**"};
		
		System.out.println(solution(user_id, banned_id));
	}

	private static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		
		HashMap<String, Integer> hash = new HashMap<>();
        List[] list = new LinkedList[banned_id.length];
        for(int i = 0; i < banned_id.length; i++) {
            list[i] = new LinkedList<>();
            hash.put(banned_id[i], hash.getOrDefault(banned_id[i], 0) + 1);
        }
        
        for(int i = 0; i < user_id.length; i++) {
            for(String key : hash.keySet()) {
                if(user_id[i].length() == key.length()) {  // hash에 있는 문자열과 user_id에 있는 문자열의 길이가 같다면
                    boolean same = true;
                    for(int j=0; j < key.length(); j++) {  // 문자열 비교
                        if(user_id[i].charAt(j) == key.charAt(j)) {
                            continue;
                        } else {
                            same = false;
                            break;
                        }
                    }
                    
                    if(same == true) {
                        list[i].add(user_id[i]);
                    }
                }
            }
        }        
        
       for (int i = 0; i < list.length; i++) {
		System.out.println(list[i]);
       }
        
		return answer;
	}

}
