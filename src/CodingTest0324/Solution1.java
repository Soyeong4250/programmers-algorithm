package CodingTest0324;

import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		// 1
//		int k = 3;  // 연속 송금
//		int m = 50000;  // 송금액
//		String[] names = {"msLEE", "jsKim", "jsKIM", "jskiM", "jskim", "John", "john", "John", "msLEE", "msLEE", "jsKIM", "roy"};
//		int[] amounts = {950, 52524, 1400, 6055, 10000, 4512, 512, 52000, 9000, 49000, 1400, 50000};
		
		// 2
		int k = 2;  // 연속 송금
		int m = 3451;  // 송금액
		String[] names = {"abcd", "aBCd", "jsKIM", "rrr", "rrr"};
		int[] amounts = {950, 1000, 1400, 4000, 10000};
		
		System.out.println(solution(k, m, names, amounts));
		
	}

	private static int solution(int k, int m, String[] names, int[] amounts) {
		int answer = 0;  // 문자 발송 횟수
		
		for (int i = 0; i < names.length; i++) {
			names[i] = names[i].toLowerCase();  // 모두 소문자로 변경
		}
		
		// 확인
//		System.out.println(Arrays.toString(names));
		
		int cnt = 0;  // 이름이 연속으로 나온 횟수
		String name = "";  // 이전 송금 이름
		for (int i = 0; i < names.length; i++) {
			if(names[i].equals(name)) {  // 이전 송금 이름과 같다면 cnt++
				cnt++;
			}else {
				name = names[i];  // 송금 이름 바꿔주기
				cnt = 1;  // 새로운 사람에게 한번 송금했으므로 1
			}
			
			// 확인
//			System.out.println(cnt+"번 연속으로 "+ names[i] + "에게 " + amounts[i] + "만큼 송금");
			
			if(cnt >= k || amounts[i] >= m) {  // 같은 사람에게 k번 이상 송금하거나 송금액이 m원 이상이라면
				answer++;  // 문자 발송 1회
//				System.out.println(answer+"번째 문자 발송");
			}
		}
		
		return answer;
	}

}
