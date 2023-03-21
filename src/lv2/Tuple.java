package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;

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
		String[] tupleArr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");

		HashSet<Integer> hash = new HashSet<>();
		
		Arrays.sort(tupleArr, (s1, s2) -> s1.length() - s2.length());		
		System.out.println(Arrays.toString(tupleArr));
		
		int[] answer = new int[tupleArr.length];
		
		int idx = 0;
		for (int i = 0; i < tupleArr.length; i++) {
			for (String str : tupleArr[i].split(",")) {
				int num = Integer.parseInt(str);
				if(hash.add(num)) {
					answer[idx++] = num;
				}
			}
		}
		
		return answer;
	}

}
