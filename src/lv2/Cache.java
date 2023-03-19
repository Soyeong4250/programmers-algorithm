package lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cache { // 캐시

	public static void main(String[] args) {
		Cache main = new Cache();

		int cacheSize = 3;
		String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };

//		int cacheSize = 3;
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

//		int cacheSize = 2;
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

//		int cacheSize = 5;
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

//		int cacheSize = 2;
//		String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};

//		int cacheSize = 0;
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

		System.out.println(main.solution(cacheSize, cities));
	}

	private int solution(int cacheSize, String[] cities) {
		int answer = 0;
		
		List<String> cache = new ArrayList<>();
		
		for (int i = 0; i < cities.length; i++) {
			String city = cities[i].toLowerCase();
			if(cache.contains(city)) {
				cache.remove(city);
				cache.add(city);
				answer += 1;
			}else {
				cache.add(city);
				if(cache.size() > cacheSize) {
					cache.remove(0);
				}
				answer += 5;
			}
		}
		
		return answer;
	}

}
