package CodingTest0508;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Solution2 {

	public static void main(String[] args) {
		String[] rooms = {"[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"};
		int target = 403;
//		String[] rooms = {"[101]Azad,Guard", "[202]Guard", "[303]Guard,Dzaz"};
//		int target = 202;
//		String[] rooms = {"[1234]None,Of,People,Here","[5678]Wow"};
//		int target = 1234;
		
		System.out.println(solution(rooms, target));
	}

	private static String[] solution(String[] rooms, int target) {
		String[] answer = {};
		
		List<List<String>> info = new ArrayList<List<String>>();
		
		for(int i=0; i<rooms.length; i++) {
			String[] tmp = rooms[i].split("\\[|\\]|,");
			boolean pass = false;
			List<String> list = new ArrayList<>();
			for(int j=1; j<tmp.length; j++) {
				// 1. target 방에 지정자리가 있다면 pass
				if(Integer.parseInt(tmp[1]) == target) {
					pass = true;
					break;
				}
				list.add(tmp[j]);
			}
			if(pass==false) {
				info.add((ArrayList<String>) list);
			}
		}
		
		// 각자 방 개수 구하기
		HashMap<String, Integer> person = new HashMap<>();
		for(int i=0; i<info.size(); i++) {
			for(int j=1; j<info.get(i).size(); j++) {
				person.put(info.get(i).get(j), person.getOrDefault(info.get(i).get(j), 0)+1);
			}
		}
		
		// 방 개수 적은 순서대로 정렬
		List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(person.entrySet());
		Collections.sort(entryList, new Comparator<Entry<String, Integer>>(){
			
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// 오름차순 정렬
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		
		//결과 출력
		for(Entry<String, Integer> entry : entryList) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		
		return answer;
	}

}
