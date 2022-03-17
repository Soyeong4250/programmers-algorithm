package SampleQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class KakaoBlindRecruitment { // 오픈채팅방

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}

	static class User{
		String command;
		String id;
		String nickName;
		public User(String command, String id, String nickName) {
			super();
			this.command = command;
			this.id = id;
			this.nickName = nickName;
		}
		@Override
		public String toString() {
			return "User [command=" + command + ", id=" + id + ", nickName=" + nickName + "]";
		}
		
	}
	
	private static String[] solution(String[] record) {
		List<User> list = new ArrayList<>();
		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);  // 각 인덱스의 문자열을 token단위로 자르기
			String command = st.nextToken();
			String id = st.nextToken();
			String nickName;
			if(!command.equals("Leave")) {
				nickName = st.nextToken();
			}else {
				nickName = null;
			}
			
			User user = new User(command, id, nickName);
			
			// 기록 추가
			if(user.command.equals("Enter")) {
				for (int j = 0; j < list.size(); j++) {
					if(user.id.equals(list.get(j).id)) {
						list.get(j).nickName = user.nickName;
					}
				}
				list.add(user);
			}else if(user.command.equals("Leave")) {
				list.add(user);
				for (int j = 0; j < list.size(); j++) {
					if(user.id.equals(list.get(j).id)) {
						user.nickName = list.get(j).nickName;
					}
				}
			}else {
				for (int j = 0; j < list.size(); j++) {
					if(user.id.equals(list.get(j).id)) {
						list.get(j).nickName = user.nickName;
					}
				}
			}
		}
		
		// 확인
//		for (User user : list) {
//			System.out.println(user);
//		}
		
		String[] answer = new String[list.size()];
		
		for (int i = 0; i < answer.length; i++) {
			if(list.get(i).command.equals("Enter")) {
				answer[i] = list.get(i).nickName+"님이 들어왔습니다.";
			}else {
				answer[i] = list.get(i).nickName+"님이 나갔습니다.";
			}
		}
		return answer;
	}

}
