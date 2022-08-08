package lv1;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class FailureRate { // 실패율

	public static void main(String[] args) {
		int N = 5; // 전체 스테이지의 개수
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 }; // 게임을 이용하는 사용자가 현재 멈춰있는 스테이지 번호 배열
//		int N = 4;  // 전체 스테이지의 개수
//		int[] stages = {4, 4, 4, 4, 4};  // 게임을 이용하는 사용자가 현재 멈춰있는 스테이지 번호 배열

		System.out.println(solution(N, stages));
	}

	static class Rate {
		int 
	}
	private static int[] solution(int N, int[] stages) {
		// 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
		int[] answer = new int[N];
		
		HashMap<Integer, Integer> hash = new HashMap<>();
		int total = stages.length;
		for(int i=0; i<stages.length; i++) {
			hash.put(stages[i], hash.getOrDefault(stages[i], 0) + 1);
		}
		
//		System.out.println(hash);
		
		for(int key:hash.keySet()) {
			
		}
		
		return answer;
	}

}
