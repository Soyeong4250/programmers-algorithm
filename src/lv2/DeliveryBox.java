package lv2;

import java.util.Stack;

public class DeliveryBox { // 택배 상자

	public static void main(String[] args) {
		DeliveryBox main = new DeliveryBox();

		int[] order = { 4, 3, 1, 2, 5 };
//		int[] order = {5, 4, 3, 2, 1};

		System.out.println(main.solution(order));
	}

	private int solution(int[] order) {
		Stack<Integer> subBelt = new Stack<Integer>();
		
		int cnt = 0;
		int idx = 0;
		for (int i = 1; i <= order.length; i++) {
			if(i != order[idx]) {
				if(!subBelt.isEmpty() && subBelt.peek() == order[idx]) {
					cnt++;
					subBelt.pop();
				} else {
					subBelt.add(i);
				}
			} else {
				cnt++;
				idx++;
			}
//			System.out.println("cnt = " + cnt);
//			System.out.println(subBelt);
		}
		
		while(idx < order.length) {
			if(subBelt.peek() == order[idx]) {
				cnt++;
				idx++;
				subBelt.pop();
			} else {
				break;
			}
		}
		
		return cnt;
	}

}
