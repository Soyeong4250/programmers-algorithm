package lv2;

import java.util.HashMap;

public class DiscountEvent { // 할인행사

	public static void main(String[] args) {
		DiscountEvent main = new DiscountEvent();

		// 3
		String[] want = { "banana", "apple", "rice", "pork", "pot" };
		int[] number = { 3, 2, 2, 2, 1 };
		String[] discount = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
				"pot", "banana", "apple", "banana" };

		// 0
//		String[] want = {"apple"};
//		int[] number = {10};
//		String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

		System.out.println(main.solution(want, number, discount));
	}

	private int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		
		HashMap<String, Integer> cart = new HashMap<>();
		for (int i = 0; i < want.length; i++) {
			cart.put(want[i], number[i]);
		}
		
		
		for (int i = 0; i < discount.length; i++) {
			if(cart.containsKey(discount[i])) {  // 사고자하는 물건이라면
				cart.put(discount[i], cart.get(discount[i]) - 1);  // 갯수 1개 줄이기
			}
			
			
			if(i >= 10 && cart.containsKey(discount[i-10])) {  // 10일 넘었다면 구매하고자 했던 품목 장바구니에서 제거
				cart.put(discount[i-10], cart.get(discount[i-10]) + 1);
			}
			
			if(buyAll(cart)) {  // 원하는 품목을 모두 담음
				answer++;
			}
			System.out.println(i+1 + "일째 = " + cart);
		}
		
		return answer;
	}

	private boolean buyAll(HashMap<String, Integer> cart) {
		System.out.println("확인 = " + cart);
		for (String key : cart.keySet()) {
			if(cart.get(key) > 0) {  // 모두 구매하지 못함
				return false;
			}
		}
		
		return true;
	}

}
