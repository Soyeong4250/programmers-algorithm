package CodingTest;

public class Money {

	public static void main(String[] args) {
		int money = 4578;
		int[] costs = {1, 4, 99, 35, 50, 1000};
		
//		int money = 1999;
//		int[] costs = {2, 11, 20, 100, 200, 600};		
		
		System.out.println(solution(money, costs));
	}

	public static int solution(int money, int[] costs) {
		int answer = 0;
		int[] cnt = new int[costs.length];
		int[] unit = {1, 5, 10, 50, 100, 500};
		
		for (int i = 5; i > 0; i--) {
			if(costs[i] > (unit[i]/unit[i-1])*costs[i-1]) {
				System.out.println(costs[i] + "현재 비용");
				continue;
			}else {
				cnt[i] = money/unit[i];
				money %= unit[i];
			}
			System.out.println(unit[i] + "원으로 나눈 나머지는 " + money);
		}
		
		cnt[0] = money/unit[0];
		
		// System.out.println(Arrays.toString(cnt));
		
		for (int i = 0; i < unit.length; i++) {
			answer += costs[i] * cnt[i];
		}
		return answer;
	}

}
