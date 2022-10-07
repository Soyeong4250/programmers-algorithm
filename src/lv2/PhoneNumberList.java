package lv2;

import java.util.HashSet;

public class PhoneNumberList { // 전화번호 목록

	public static void main(String[] args) {
//		String[] phone_book = {"119", "97674223", "1195524421"};
//		String[] phone_book = {"97674223", "119", "1195524421"};
//		String[] phone_book = {"123","456","789"};
//		String[] phone_book = {"12","123","1235","567","88"};
		String[] phone_book = {"819232312", "976", "119552", "2"};
		
		System.out.println(solution(phone_book));
	}

	private static boolean solution(String[] phone_book) {
		
		HashSet<String> hash = new HashSet<>();
		
		for (int i = 0; i < phone_book.length; i++) {
			hash.add(phone_book[i]);
		}
		
		for (String num : phone_book) {
			for (int j = 1; j < num.length(); j++) {
				if(hash.contains(num.substring(0, j))) {
					return false;
				}
			}
		}
		
		return true;
	}

	/*private static boolean solution(String[] phone_book) {
		
		Arrays.sort(phone_book);
		// 확인
		System.out.println(Arrays.toString(phone_book));
		
		
		for (int i = 0; i < phone_book.length-1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) {
				return false;
			}
		}

		return true;
	}*/
	
	

}
