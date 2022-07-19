package lv1;

public class AmountOfCalculation { // 부족한 금액 계산하기

	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;

		System.out.println(solution(price, money, count));
	}

	private static long solution(int price, int money, int count) {
		long answer = -1;
		
		long sum = 0;
		for (int i = 1; i <= count; i++) {
			sum += price*i;
		}
		
		answer = money - sum;
		if(answer > 0) {
			answer = 0;
		}
		
		return Math.abs(answer);
	}

}
