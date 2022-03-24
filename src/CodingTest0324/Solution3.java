package CodingTest0324;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution3 {
	static class Bank {
		String date;
		int rate;
		int money;
		
		public Bank(String date, int rate, int money) {
			super();
			this.date = date;
			this.rate = rate;
			this.money = money;
		}
		
	}

	public static void main(String[] args) {
		// 1
		String[] ledgers = {"01/01 4 50000","01/11 6 3555","02/01 0 -23555","02/25 5 5000","03/25 0 -15000","06/09 8 43951","12/30 9 99999"};
		
		// 2
		// String[] ledgers = {"04/01 1 40000","05/01 5 20000","08/31 4 10000","11/11 0 -45000"};
	
		System.out.println(solution(ledgers));
	}

	private static int solution(String[] ledgers) {
		int answer = 0;  // 이자
		
		Stack<Bank> bank = new Stack<>();
		for (int i = 0; i < ledgers.length; i++) {
			StringTokenizer st = new StringTokenizer(ledgers[i]);
			String date = st.nextToken();
			int rate = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			
			Bank b = new Bank(date, rate, money);
			if(money > 0) {
				bank.push(b);
			}else {  // money가 0보다 작거나 같다면 (출금)
				while(Math.abs(money) != 0) {
					Bank recent = bank.pop();
					b.money -= recent.money;
					answer += Math.round((recent.money*rate/100)*(cal(recent)/365));
					System.out.println(answer);
					System.out.println(b.money);
				}
			}
			
		}
		
		
		return answer;
	}

	// 예치 기간 구하기
	private static int cal(Bank recent) {
		int result = 0;
		
		int month = Integer.parseInt(recent.date.substring(0, 1));
		int day = Integer.parseInt(recent.date.substring(recent.date.lastIndexOf("/")+1));
		
		if(month == 1 || month == 3 || month == 5|| month == 7 || month == 8 || month == 10 || month == 12) {
			result = 31-Integer.parseInt(recent.date.substring(recent.date.lastIndexOf("/")+1));
		}else if(month == 2) {
			result = 28 - Integer.parseInt(recent.date.substring(recent.date.lastIndexOf("/")+1));
		}else {
			result = 30 - Integer.parseInt(recent.date.substring(recent.date.lastIndexOf("/")+1));
		}
		
		return result;
	}


}
