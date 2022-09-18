package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SearchRank { // 순위 검색

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		System.out.println(solution(info, query));
	}

	static HashMap<String, List<Integer>> hash;
	private static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		
		hash = new HashMap<>();
		for (int i = 0; i < info.length; i++) {
			String[] arr = info[i].split(" ");
			combination(arr, 0, "");
		}
		
		System.out.println(hash);
		for (String key : hash.keySet()) {
			Collections.sort(hash.get(key));
		}
		
		for (int i = 0; i < query.length; i++) {
//			String[] sample = query[i].split(" and ");
//			System.out.println(Arrays.toString(sample));
			
//			StringBuilder sb = new StringBuilder();
//			sb.append(sample[0]);
//			sb.append(sample[1]);
//			sb.append(sample[2]);
//			sb.append(sample[3]);
			query[i] = query[i].replaceAll(" and ", "");
			String[] sample = query[i].split(" ");
			if(!hash.containsKey(sample[0])) {
				answer[i] = 0;
			}else {
				List<Integer> subList = hash.get(sample[0]);
//				Collections.sort(subList);
				int start = 0;
				int end = subList.size()-1;
				int score = Integer.parseInt(sample[1]);
				while(start <= end) {
					int mid = (start+end)/2;
					if(subList.get(mid) < score) {
						start = mid + 1;
					} else {
						end = mid - 1;
					}
				}
				
				answer[i] = subList.size() - start;
			}
		}
		
		System.out.println("answer");
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	private static void combination(String[] arr, int idx, String str) {
		if(idx == 4) {  // 점수 부분이이라면
			if (!hash.containsKey(str)){  // 존재하지 않는 key라면
				List<Integer> list = new ArrayList<>();
				hash.put(str, list);
			}
			hash.get(str).add(Integer.parseInt(arr[4]));
			return;
		}
		
		combination(arr, idx+1, str+arr[idx]);
		combination(arr, idx+1, str+"-");
	}

}
