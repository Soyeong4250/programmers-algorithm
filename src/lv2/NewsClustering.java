package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsClustering { // 뉴스 클러스터링

	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";
//		String str1 = "handshake";
//		String str2 = "shake hands";
//		String str1 = "aa1+aa2";
//		String str2 = "AAAA12";
//		String str1 = "E=M*C^2";
//		String str2 = "e=m*c^2";

		System.out.println(solution(str1, str2));
	}

	private static int solution(String str1, String str2) {
		List<String> list1 = new ArrayList<>();
		for(int i = 0; i<str1.length(); i+=2) {
			String s = str1.substring(i, i+2).toLowerCase();
			if(s.matches("(.*)[^0-9a-z](.*)")) {
				System.out.println("숫자나 영문 소문자 외의 다른 문자 포함");
				continue;
			}
			list1.add(s);
		}
		List<String> list2 = new ArrayList<>();
		for(int i = 0; i<str2.length(); i+=2) {
			String s = str2.substring(i, i+2);
			if(s.contains("(.*)[^0-9a-z](.*)")) {
				System.out.println("숫자나 영문 소문자 외의 다른 문자 포함");
				continue;
			}
			list2.add(s);
		}
		
//		System.out.println(list1);
//		System.out.println(list2);
		
		if(list1.size() == 0 && list2.size() == 0) {
			return 65536;
		}
		
		int union = list1.size() + list2.size();  // 합집합 길이 + 교집합 길이
		list1.retainAll(list2);  // 교집합
		int inter = list1.size();  // 교집합 길이
		union -= inter;  // 합집합 길이
		System.out.println(union + ", " + inter);
		
		double j = (double)inter/(double)union; 
		System.out.println(j);
		j *= 65536;
		
		return (int)Math.floor(j);
	}

}
