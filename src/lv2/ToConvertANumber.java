package lv2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ToConvertANumber { // 숫자 변환하기

	public static void main(String[] args) {
		ToConvertANumber main = new ToConvertANumber();

		// 2
//		int x = 10;
//		int y = 40;
//		int n = 5;

		// 1
//		int x = 10;
//		int y = 40;
//		int n = 30;

		// -1
//		int x = 2;
//		int y = 5;
//		int n = 4;
		
		// 1
		int x = 38;
		int y = 40;
		int n = 2;

		System.out.println(main.solution(x, y, n));
	}

	class Info {
		int result;
		int depth;
		
		public Info (int result, int depth) {
			this.result = result;
			this.depth = depth;
		}
	}
	
	private int solution(int x, int y, int n) {
		int answer = -1;
		
		Queue<Info> operation = new LinkedList<>();
		HashSet<Integer> memo = new HashSet<>();
		
		operation.add(new Info(x, 0));
		
		while(!operation.isEmpty()) {
			Info info = operation.poll();
			System.out.println("result = " + info.result);
			
			if(x == y) {
				answer = 0;
				break;
			} else if(info.result + n == y || info.result * 2 == y || info.result * 3 == y) {
				answer = info.depth + 1;
				break;
			} else if (info.result + n > y && info.result * 2 > y && info.result * 3 > y) {
				break;
			}
			
			if(info.result + n < y && !memo.contains(info.result + n)) {
				operation.add(new Info(info.result + n, info.depth+1));
				memo.add(info.result + n);
			}
			if(info.result * 2 < y && !memo.contains(info.result * 2)) {
				operation.add(new Info(info.result * 2, info.depth+1));
				memo.add(info.result * 2);
			}
			if(info.result * 3 < y && !memo.contains(info.result * 3)) {
				operation.add(new Info(info.result * 3, info.depth+1));
				memo.add(info.result * 3);
			}
				
			System.out.println("answer = " + answer);
		}
		
		
		return answer;
	}

}
