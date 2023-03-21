package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Tuple { // 튜플

	public static void main(String[] args) {
		Tuple main = new Tuple();

//		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//		String s = "{{20,111},{111}}";
//		String s = "{{123}}";
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

		System.out.println(Arrays.toString(main.solution(s)));
	}

	private int[] solution(String s) {
		s = s.substring(2, s.length()-2).replace("},{", "/");
//		System.out.println(s);
		String[] tupleArr = s.split("/");

		HashMap<Integer, Integer> hash = new HashMap<>();
		
//		System.out.println(Arrays.toString(tupleArr));
		for (int i = 0; i < tupleArr.length; i++) {
			String[] str = tupleArr[i].split(",");
			for (int j = 0; j < str.length; j++) {
				int num = Integer.parseInt(str[j].trim());
				hash.put(num, hash.getOrDefault(num, 0) + 1);
				
			}
		}
		
		List<int[]> numList = new ArrayList<int[]>();
		for (Map.Entry<Integer, Integer> num : hash.entrySet()) {
			numList.add(new int[]{num.getKey(), num.getValue()});
		}
		
		Collections.sort(numList, (s1, s2) -> s2[1] - s1[1]);
		
		int[] answer = new int[numList.size()];
		for (int i = 0; i < numList.size(); i++) {
			answer[i] = numList.get(i)[0];
		}
		return answer;
	}

}
