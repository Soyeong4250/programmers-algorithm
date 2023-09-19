package lv2;

import java.util.*;

public class SkillTree { // 스킬트리

	public static void main(String[] args) {
		SkillTree main = new SkillTree();

		// 2
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

		System.out.println(main.solution(skill, skill_trees));
		System.out.println(main.solution1(skill, skill_trees));
	}

	public int solution1(String skill, String[] skill_trees) {
		int answer = 0;

		List<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));
		for (String str : skillTrees) {
			System.out.println("str = " + str);
		}

		Iterator<String> it = skillTrees.iterator();

		// hasNext() -> next() -> remove()
		while (it.hasNext()) {
			String str = it.next();
			System.out.println("it.next() = " + str);
			System.out.println(str.replaceAll("[^" + skill + "]", ""));  // skill에 포함되지 않은 문자 제거
			System.out.println(skill.indexOf(str.replaceAll("[^" + skill + "]", "")));  // skill에서 문자열 시작 인덱스 구하기
			if (skill.indexOf(str.replaceAll("[^" + skill + "]", "")) != 0) {
				it.remove();  // skill에 해당하지 않는 문자열 제거
			}
		}

		answer = skillTrees.size();

		return answer;
	}

	private int solution(String skill, String[] skill_trees) {
		int answer = 0;

		HashMap<Character, Integer> skillMap = new HashMap<>();
		for (int i = 0; i < skill.length(); i++) {
			skillMap.put(skill.charAt(i), i);
		}

		boolean[] check = new boolean[skillMap.size()];

		for (int t=0; t<skill_trees.length; t++) {
			Arrays.fill(check, false);

			boolean possible = true;
			System.out.println(skill_trees[t]);
			for (int i = 0; i < skill_trees[t].length(); i++) {
				char ch = skill_trees[t].charAt(i);

				if(skillMap.containsKey(ch)) {
					System.out.println(ch);
					int idx = skillMap.get(ch);

					if(idx > 0) {
						if (!check[idx-1]) {
							possible = false;
							System.out.println("불가능");
							break;
						}
					}
					check[idx] = true;
				}
				System.out.println(Arrays.toString(check));
			}

			if(possible) {
				answer += 1;
			}
		}

		return answer;
	}

}
