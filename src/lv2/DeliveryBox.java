package lv2;

import java.util.Stack;

public class DeliveryBox { // 택배 상자

	public static void main(String[] args) {
		DeliveryBox main = new DeliveryBox();

		int[] order = { 4, 3, 1, 2, 5 };
//		int[] order = {5, 4, 3, 2, 1};
//		int[] order = {1, 3, 5, 2, 4};
//		int[] order = {3, 2, 1, 4, 5};
		System.out.println(main.solution(order));
	}

	private int solution(int[] order) {
		Stack<Integer> subBelt = new Stack<Integer>();
		
		int num = 1;
		int cnt = 0;
		int idx = 0;
		
		while(idx < order.length && num <= order.length) {
			
			System.out.println("num = " + num + ", " + order[idx]);
			if(num != order[idx]) {
//				System.out.println("num과 order[idx] 불일치" + num + ", " + order[idx]);
				if(!subBelt.isEmpty() && subBelt.peek() == order[idx]) {
					System.out.println("stack pop()");
					subBelt.pop();
					idx++;
					cnt++;
				} else {
					System.out.println("stack add()");
					subBelt.add(num);
					num++;
				}
			} else {
				System.out.println("pass");
				num++;
				idx++;
				cnt++;
			}
		}
		
		while(idx < order.length) {
			if(subBelt.peek() == order[idx]) {
				subBelt.pop();
				cnt++;
				idx++;
			}else {
				break;
			}
		}
		
		return cnt;
	}

}
