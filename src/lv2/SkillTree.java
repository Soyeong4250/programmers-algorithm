package lv2;

import java.util.Arrays;
import java.util.HashMap;

public class SkillTree { // 스킬 트리

	public static void main(String[] args) {
		SkillTree main = new SkillTree();

		// 2
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

		System.out.println(main.solution(skill, skill_trees));
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
