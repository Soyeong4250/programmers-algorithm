package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PersonalInformation { // 개인정보 수집 유효기간

	public static void main(String[] args) {
		PersonalInformation main = new PersonalInformation();

		// [1, 3]
//		String today = "2022.05.19";
//		String[] terms = { "A 6", "B 12", "C 3" };
//		String[] privacles = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };

		// [1, 4, 5]
//		String today = "2020.01.01";
//		String[] terms = {"Z 3", "D 5"};
//		String[] privacles = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

		// [2]
//		String today = "2010.01.01";
//		String[] terms = {"A 12"};
//		String[] privacles = {"2009.12.01 A", "2001.01.01 A"};

		// [1]
//		String today = "2016.02.15";
//		String[] terms = {"A 100"};
//		String[] privacles = {"2000.06.16 A", "2008.02.15 A"};
		
		// [1]
//		String today = "2011.12.18";
//		String[] terms = {"A 13"};
//		String[] privacles = {"2001.01.01 A", "2010.11.28 A"};

		// [1]
//		String today = "2020.01.01";
//		String[] terms = {"A 1"};
//		String[] privacles = {"2019.12.01 A"};

		// [2]
//		String today = "2021.01.28";
//		String[] terms = {"A 2"};
//		String[] privacles = {"2020.12.01 A", "2010.01.01 A"};

		// [1, 2]
		String today = "2020.12.17";
		String[] terms = {"A 12"};
		String[] privacles = {"2010.01.01 A", "2019.12.17 A"};
		
		System.out.println(Arrays.toString(main.solution(today, terms, privacles)));

	}

	private int[] solution(String today, String[] terms, String[] privacles) {
		List<Integer> answerList = new ArrayList<>();
		
		// 약관별 유효기간 정보
		HashMap<String, Integer> expirationDate = new HashMap<>();
		for (int i = 0; i < terms.length; i++) {
			expirationDate.put(terms[i].split(" ")[0], Integer.parseInt(terms[i].split(" ")[1]));
		}
		
		for (int i = 0; i < privacles.length; i++) {
			String date = privacles[i].split(" ")[0];
			String condition = privacles[i].split(" ")[1];
			
			int finalDate = plusMonth(date, condition, expirationDate);
			
			if(isExpired(finalDate, changeDateToInt(today))) {
				System.out.println("만료됨");
				answerList.add(i+1);
			}
			System.out.println("----------------------");
		}
		
		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
		
		return answer;
	}

	private boolean isExpired(int finalDate, int today) {
		System.out.println("finalDate = " + finalDate);
		System.out.println("today = " + today);
		System.out.println("비교결과 = "  + (today - finalDate));
		if(finalDate > today) {  // 유효기간 마지막날이 오늘날짜보다 더 이후인 경우
			return false;
		}
		
		return true;
	}

	private int plusMonth(String date, String condition, HashMap<String, Integer> expirationDate) {
		int finalDate = changeDateToInt(date);
		int month = expirationDate.get(condition) * 28;
		
		return finalDate + month;
	}

	private int changeDateToInt(String date) {
		String[] dateArr = date.split("\\.");
		int totalDate = Integer.parseInt(dateArr[0]) * 12 * 28 + Integer.parseInt(dateArr[1]) * 28 + Integer.parseInt(dateArr[2]);
		return totalDate;
	}

}
