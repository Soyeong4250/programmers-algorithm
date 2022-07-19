package lv1;

public class FindMrKim {  // 서울에서 김서방 찾기

	public static void main(String[] args) {
		String[] seoul = {"Jane", "Kim"};
		
		System.out.println(solution(seoul));
	}

	private static String solution(String[] seoul) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("김서방은 ");
		for (int i = 0; i < seoul.length; i++) {
			if(seoul[i].equals("Kim")) {
				sb.append(i + "에 있다");
				break;
			}
		}
		
		return sb.toString();
	}

}
