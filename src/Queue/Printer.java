package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
	static class Print {
		int prior;
		int idx;
		
		public Print(int prior, int idx) {
			super();
			this.prior = prior;
			this.idx = idx;
		}
    }

	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;

		System.out.println(solution(priorities, location));

	}

	private static int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Print> q = new LinkedList<>();
		
		// q에 데이터 넣기
		for (int i = 0; i < priorities.length; i++) {
			Print p = new Print(priorities[i], i);
			q.add(p);
		}
		
		while(!q.isEmpty()) {
			boolean flag = false;
			Print first = q.poll();
			for (Print print : q) {
				if(first.prior < print.prior) {
					flag = true;
					break;
				}
				
			}
			if(flag) {
				q.add(first);
			}else {
				answer++;
				if(first.idx == location) {
					break;
				}
			}
		}
		
		return answer;
	}

}
