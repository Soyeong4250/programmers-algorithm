package lv1;

import java.util.Stack;

public class Hamburger { // 햄버거 만들기

	public static void main(String[] args) {
		Hamburger main = new Hamburger();

		// 2
		int[] ingredient = { 2, 1, 1, 2, 3, 1, 2, 3, 1 };

		// 0
//		int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};

		System.out.println(main.solution(ingredient));
	}

	private int solution(int[] ingredient) {
		int answer = 0;
		
		Stack<Integer> stack = new Stack();
		
		for (int i = 0; i < ingredient.length; i++) {
			stack.add(ingredient[i]);
			
			if(stack.size() >= 4 && stack.get(stack.size()-1) == 1
					&& stack.get(stack.size()-2) == 3
					&& stack.get(stack.size()-3) == 2
					&& stack.get(stack.size()-4) == 1) {
				answer += 1;
				stack.pop();
				stack.pop();
				stack.pop();
				stack.pop();
			}
		}
		return answer;
	}
	

	// 시간초과
	/*
	 * private int solution(int[] ingredient) { int answer = 0; StringBuilder sb =
	 * new StringBuilder();
	 * 
	 * for (int i = 0; i < ingredient.length; i++) { sb.append(ingredient[i]); }
	 * 
	 * String ingredientStr = sb.toString(); String burger = "1231";
	 * System.out.println(ingredientStr); while(ingredientStr.contains(burger)) {
	 * answer += 1; ingredientStr = ingredientStr.replaceFirst(burger, "");
	 * System.out.println(ingredientStr); }
	 * 
	 * return answer; }
	 */

}
