package SampleQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class KakaoBlindRecruitment2 { // 오픈채팅방

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}
	
	private static String[] solution(String[] record) {
		HashMap<String, String>map = new HashMap<>();
		for (int i = 0; i < record.length; i++) {
			StringTokenizer st  = new StringTokenizer(record[i]);
			String command = st.nextToken();
			String id = st.nextToken();
			String nickName;
			if(!command.equals("Leave")) {
				nickName = st.nextToken();
			} else {
				nickName = null;
			}
			
			if(command.equals("Enter")) {
				map.put(id, nickName);
			} else if(command.equals("Change")) {
				map.put(id, nickName);
			}
		}
		
		List<String> tmp = new ArrayList<>();
		
		for (int i = 0; i < record.length; i++) {
			StringTokenizer st  = new StringTokenizer(record[i]);
			String command = st.nextToken();
			String id = st.nextToken();
			
			if(command.equals("Enter")) {
				tmp.add(map.get(id) + "님이 들어왔습니다.");
			}else if(command.equals("Leave")){
				tmp.add(map.get(id)+ "님이 나갔습니다.");
			}
		}
		
		String[] answer = new String[tmp.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = tmp.get(i).toString();
		}
		
		return answer;
	}

}
