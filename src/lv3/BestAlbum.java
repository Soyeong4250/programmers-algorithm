package lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class BestAlbum {  // 베스트 앨범

	public static void main(String[] args) {
		BestAlbum bestAlbum = new BestAlbum();
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};

		System.out.println(bestAlbum.solution(genres, plays));
	}

	private int[] solution(String[] genres, int[] plays) {
		// 1. 속한 노래가 가장 많은 장르
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			map.put(genre, map.getOrDefault(genre, 0) + plays[i]);
		}
		
		System.out.println(map);

		// 확인
		System.out.println("====================1=====================");
		for (String key : map.keySet()) {
			System.out.println(String.format("장르명 : %s, 재생횟수: %d", key, map.get(key)));
		}System.out.println();

		List<String> listKeySet = new ArrayList<>(map.keySet());
		
		// 내림차순 정렬
		Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
		// 확인
		System.out.println("====================2=====================");
		for(String key : listKeySet) {
			System.out.println("key : " + key + " , " + "value : " + map.get(key)); 
		}System.out.println();
		
		
		// 2. 재생  횟수가 가장 많은 노래
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < listKeySet.size(); i++) {
			String genre = listKeySet.get(i);
			// 첫번째
			int max = 0;
			int first = -1;
			for (int j = 0; j < genres.length; j++) {
				if(genre.equals(genres[j]) && max < plays[j] && j != first) {
					max = plays[j];
					first = j;
				}
			}
			// 두번째
			max = 0;
			int second = -1;
			for (int j = 0; j < genres.length; j++) {
				if(genre.equals(genres[j]) && max < plays[j] && j != first) {
					max = plays[j];
					second = j;
				}
			}
			
			list.add(first);
			// 한 장르에 한곡만 있을 경우에는 두번째 곡 추가 x
			if(second != -1) {
				list.add(second);
			}			
		}
		
		int[] result = new int[list.size()];
		for (int j = 0; j < list.size(); j++) {
			result[j] = list.get(j);
		}
		
		System.out.println(Arrays.toString(result));
		return result;
	}
	

}
