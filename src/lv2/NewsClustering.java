package lv2;

import java.util.ArrayList;
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
		// 1. 문자열을 모두 소문자로 바꿔주기 (대소문자 구분없이 비교하기 위해)
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		// 2. 각 문자열을 2글자씩 끊어서 List에 담아주기
		List<String> list1 = new ArrayList<>();
		for(int i = 0; i<str1.length()-1; i++) {
			String s = str1.substring(i, i+2);
			if(s.matches("(.*)[^a-z](.*)") || s.trim().length() < 2) {
//				System.out.println("영문 소문자 외의 다른 문자 포함");
				continue;
			}
			list1.add(s);
		}
		List<String> list2 = new ArrayList<>();
		for(int i = 0; i<str2.length()-1; i++) {
			String s = str2.substring(i, i+2);
			if(s.matches("(.*)[^a-z](.*)") || s.trim().length() < 2) {
//				System.out.println("영문 소문자 외의 다른 문자 포함");
				continue;
			}
			list2.add(s);
		}
		
//		System.out.println("list1 : " + list1);
//		System.out.println("list2 : " + list2);

		
		// 3. 교집합 개수 구하기 (list1의 원소가 list2에 포함되어 있다면 중복되는 원소를 list2에서 지워주고 교집합 변수 +1)
		int inter = 0;
		// 교집합 개수 구하기
		for(String s: list1) {
			if(list2.contains(s)) {
				list2.remove(s);
				inter++;
			}
		}
		
		// 4. 합집합 개수 구하기 (list1과 중복된 원소가 지워진 list2의 길이를 합치기)
		int union = list1.size() + list2.size();
		
		// 5. 두 리스트 모두 공집합이라면 자카드 유사도가 1이므로 65536 return
		if(union == 0) {
//			System.out.println(union);
			return 65536;
		} else {  // 6. 두 리스트 중 하나라도 공집합이 아니라면 자카드 유사도(교집합/합집합) 구한 후 65536 곱하고 정수부분만 return
			double j = (double)inter/(double)union; 
//			System.out.println(j);
			j *= 65536;
		
			return (int)Math.floor(j);
		}
	}

}
