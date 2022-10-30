package lv3;

public class Theft { // 도둑질

	public static void main(String[] args) {
		Theft main = new Theft();

		int[] money = { 1, 2, 3, 1 };
		System.out.println(main.solution(money));
	}

	private int solution(int[] money) {
		int answer = -1;
		
		// 첫 집부터 털었을 때 메모 배열(마지막집은 털지 x)
		int[] dp1 = new int[money.length];
		// 첫 집을 털지않았을 때 메모 배열
		int[] dp2 = new int[money.length];
		
		// 시작 값
		dp1[0] = dp1[1] = money[0];
		dp2[0] = 0;
		dp2[1] = money[1];
		
		for (int i = 2; i < dp2.length; i++) {			
			if(i < dp1.length-1) {
				dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
//				answer = Math.max(dp1[i], answer);
			}
			dp2[i] = Math.max(dp2[i-1], dp2[i-2]+money[i]);
//			answer = Math.max(dp2[i], answer);
		}
		
		answer = Math.max(dp1[dp1.length-2], dp2[dp2.length-1]);
		
		return answer;
	}

}
