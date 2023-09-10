package lv1;

import java.util.Arrays;
import java.util.HashMap;

public class RunningRace { // 달리기

	public static void main(String[] args) {
		RunningRace main = new RunningRace();

		String[] players = { "mumu", "soe", "poe", "kai", "mine" };
		String[] callings = { "kai", "kai", "mine", "mine" };

		System.out.println(Arrays.toString(main.solution(players, callings)));
	}

	private String[] solution(String[] players, String[] callings) {
		
		HashMap<String, Integer> rank = new HashMap<>();
		
		for (int i = 0; i < players.length; i++) {
			rank.put(players[i], i);
		}
		
		for (int i = 0; i < callings.length; i++) {
			// 추원한 선수의 원래 인덱스 구하기
			int idx = rank.get(callings[i]);
			System.out.println(callings[i] + "의 원래 순위는 " + idx);
			
			// 순위 바꾸기
			String temp = players[idx];
			players[idx] = players[idx-1];
			rank.put(players[idx-1], rank.get(players[idx-1])+1);
//			System.out.println("swap = " + rank);
			players[idx-1] = temp;
			rank.put(temp, rank.get(temp)-1);
//			System.out.println("swap = " + rank);
			
			
			System.out.println(rank);
			System.out.println(Arrays.toString(players));
		}
		
		return players;
	}

}
