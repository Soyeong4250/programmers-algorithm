package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ParkingFee { // 주차 요금 계산

	public static void main(String[] args) {
		ParkingFee main = new ParkingFee();

		// [14600, 34400, 5000]
//		int[] fees = { 180, 5000, 10, 600 };
//		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
//				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };

		// [0, 591]
//		int[] fees = {120, 0, 60, 591};
//		String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

		// [14841]
		int[] fees = {1, 461, 1, 10};
		String[] records = {"00:00 1234 IN"};

		System.out.println(Arrays.toString(main.solution(fees, records)));
	}
	
	class Info {
		int time;
		String number;
		String state;
		
		public Info(int time, String number, String state) {
			this.time = time;
			this.number = number;
			this.state = state;
		}
	}

	private int[] solution(int[] fees, String[] records) {
		HashMap<String, Info> inHash = new HashMap<>();
		HashMap<String, Integer> timeHash = new HashMap<>();
		final int finalTime = changeToMinute("23:59");  // 23:59 
		
		for (int i = 0; i < records.length; i++) {			
			String[] park = records[i].split(" ");
			System.out.println(Arrays.toString(park));
			
			if(park[2].equals("IN")) {
				Info info = new Info(changeToMinute(park[0]), park[1], park[2]);
				inHash.put(park[1], info);
				System.out.println("in = " + inHash);
			} else if(park[2].equals("OUT")) {
				int minute = changeToMinute(park[0]) - inHash.get(park[1]).time;
				System.out.println("minute = " + minute);
				
				timeHash.put(park[1], timeHash.getOrDefault(park[1], 0) + minute);
				System.out.println("timeHash = " + timeHash);
				
				inHash.remove(park[1]);
			}
		}
		
		if(!inHash.isEmpty()) {
			System.out.println("inHash is not Empty");
			
			for (String key : inHash.keySet()) {				
				timeHash.put(key, timeHash.getOrDefault(key, 0) + finalTime - inHash.get(key).time);
				System.out.println("timeHash = " + timeHash);
			}
		}
		
		List<String> sortMap = new ArrayList<>(timeHash.keySet());
		Collections.sort(sortMap);
		
		int[] answer = new int[sortMap.size()];
		for (int i = 0; i < sortMap.size(); i++) {
			int parkTime = timeHash.get(sortMap.get(i));
			System.out.println(Math.ceil((parkTime-fees[0])/(double)fees[2]));
			System.out.println(String.format("%d + [ (%d - %d) / %d] * %d = %d", fees[1], parkTime, fees[0], fees[2], fees[3], fees[1] + (int)Math.ceil((parkTime-fees[0])/(double)fees[2])*fees[3]));
			answer[i] = parkTime > fees[0] ? fees[1] + (int)Math.ceil((parkTime-fees[0])/(double)fees[2])*fees[3] : fees[1];
		}
		
		return answer;
	}

	private int changeToMinute(String time) {
		int hour = Integer.parseInt(time.split(":")[0]);
		int minute = Integer.parseInt(time.split(":")[1]);
		
		return hour * 60 + minute;
	}

}
