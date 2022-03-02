package Hash;

import java.util.HashMap;

public class camouflage { // 위장

	public static void main(String[] args) {
		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		System.out.println(solution(clothes));
	}

	private static int solution(String[][] clothes) {
		// int answer = 0;
		
		// 2가지 이상의 조합
		HashMap<String, Integer> map = new HashMap<>();
				
		for (int i = 0; i < clothes.length; i++) {
			String t = clothes[i][1];
			map.put(t,  map.getOrDefault(t, 1) + 1);  // 착용을 안했을때까지 합쳐서 1부터 시작
		}
				
		// 확인
		for (String key : map.keySet()) {  
			System.out.println(String.format("타입 : %s, 값: %d", key, map.get(key)));
		}
				
		int answer = 1;
		// 조합의 수 구하기
		for (int cnt : map.values()) {
			answer *= cnt;
		}
				
		answer -= 1;  // 모두 착용x
				
		return answer;
	}

}
