package lv2;

import java.util.Arrays;
//import java.util.Comparator;

public class PhoneNumberList { // 전화번호 목록

	public static void main(String[] args) {
//		String[] phone_book = {"119", "97674223", "1195524421"};
		String[] phone_book = {"97674223", "119", "1195524421"};
//		String[] phone_book = {"123","456","789"};
//		String[] phone_book = {"12","123","1235","567","88"};
		
		System.out.println(solution(phone_book));
	}

	private static boolean solution(String[] phone_book) {
//		boolean answer = true;
		
//		System.out.println(Arrays.toString(phone_book));
		// 길이 짧은 순으로 정렬
//		Arrays.sort(phone_book, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				
//				return o1 - o2;
//			}
//		});
		
		Arrays.sort(phone_book);
		// 확인
		System.out.println(Arrays.toString(phone_book));
		
//		for (int i = 0; i < phone_book.length-1; i++) {
//			for (int j = i+1; j < phone_book.length; j++) {
//				if(phone_book[i].charAt(0) != phone_book[j].charAt(0)) {
//					continue;
//				}
//				if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
//					return false;
//				}
//			}
//		}
		
		
//		for (int i = 0; i < phone_book.length-1; i++) {
//			if(phone_book[i+1].startsWith(phone_book[i])) {
//				return false;
//			}
//		}
		
		for (int i = 0; i < phone_book.length-1; i++) {
			for (int j = i+1; j < phone_book.length; j++) {
				if(phone_book[i+1].startsWith(phone_book[i])) {
					return false;
				}
			}
		}
		return true;
	}

}
