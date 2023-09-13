package lv2;

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
		StringBuilder skillStr = new StringBuilder();
		
		for (int i = 0; i < skill_trees.length; i++) {
			skillStr.delete(0, skillStr.length());
			String finalStr = skill.substring(skill.length()-1);
			for (int j = 0; j < skill_trees[i].length()-1; j++) {
				String s = skill_trees[i].substring(j, j+1);
				if(skill.contains(s)) {
					skillStr.append(s);
				}
				if(finalStr.equals(s)) {
					break;
				}
			}
			System.out.println(skillStr);
			
			if()
		}
		
		return answer;
	}

}
