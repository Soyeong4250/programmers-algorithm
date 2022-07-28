package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

public class CandidateKey { // 후보키

	public static void main(String[] args) {
//		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
//				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
//				{ "600", "apeach", "music", "2" } };
		String[][] relation = { { "a", "1", "aaa", "c", "ng" }, { "a", "1", "bbb", "e", "g" },
				{ "c", "1", "aaa", "d", "ng" }, { "d", "2", "bbb", "d", "ng" }};

		System.out.println(solution(relation));
	}

	static List<String> key;

	private static int solution(String[][] relation) {
		key = new ArrayList<String>();
		HashSet<String> hash = new HashSet<>();
		for (int i = 1; i <= relation[0].length; i++) {
			Combination(relation, 0, 0, i, new boolean[relation[0].length], "");
		}
		
//		System.out.println(key);  // 최종 후보키 리스트 출력
		
		return key.size();
	}

	private static void Combination(String[][] relation, int idx, int cnt, int depth, boolean[] v, String candi) {
		if (cnt == depth) { // 모두 선택
			HashSet<String> hash = new HashSet<>();
			for (int i = 0; i < relation.length; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < v.length; j++) {
					if (v[j]) {
						sb.append(relation[i][j] + " ");
					}
				}
				hash.add(sb.toString().trim());
			}
//			System.out.println(depth + " ," + hash);
			if(hash.size() == relation.length) {
				System.out.println("candi는 " + candi);
				System.out.println("유일성 만족");
				if(key.size() == 0) {  // 후보키 리스트가 비어있을 때는 후보키 리스트에 무조건 인덱스 추가 (최소성 만족)
					key.add(candi.trim());
				} else {
					System.out.println("key는 " + key);
					boolean flag = false;
					for(String k : key) {  // 후보키 리스트에 있는 인덱스를 포함한다면 인덱스 추가x (최소성 만족x)
						System.out.println("k는 " + k);
						String[] arr = k.split(" ");
						for(int i=0; i<arr.length; i++) {
							if(candi.matches(".*" + arr[i] + ".*")) {
								System.out.println(arr[i] + "포함");
								continue;
							} else {
								flag = true;
								break;
							}
						}
						
						if(!flag) {
							System.out.println("최소성 불만족");
							break;
						}
					}
					if(flag) {
						System.out.println("최소성 만족");
						key.add(candi);
					}
				}
			}
			
			return;
		}
		
		if (idx == relation[0].length) {
//			System.out.println("마지막 인덱스 입니다.");
			return;
		}

		for (int i = idx; i < relation[0].length; i++) {
			if (v[i])
				continue;
			v[i] = true;
			Combination(relation, i + 1, cnt + 1, depth, v, candi + String.valueOf(i) + " ");
			v[i] = false;
		}
	}

}
