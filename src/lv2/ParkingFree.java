package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.HashMap;

import jdk.nashorn.internal.parser.TokenStream;

public class ParkingFree {  // 주차요금
	static class Records {
		String time;
		String carNum;
		String status;
		
		public Records(String time, String carNum, String status) {
			super();
			this.time = time;
			this.carNum = carNum;
			this.status = status;
		}
	}
	
	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
//		int[] fees = {120, 0, 60, 591};
//		String[] records = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
//		int[] fees = {1, 461, 1, 10};
//		String[] records = {"00:00 1234 IN"};
		
		System.out.println(solution(fees, records));
	}

	private static int[] solution(int[] fees, String[] records) {
		int[] answer = {};
		
		List<Records> list = new ArrayList<>();
		
		for(int i=0; i<records.length; i++) {
			StringTokenizer st = new StringTokenizer(records[i]);
			Records r = new Records(st.nextToken(), st.nextToken(), st.nextToken());
			list.add(r);
		}
		
		HashMap<String, Integer> hash = new HashMap<>();
		for(int i=0; i<list.size(); i++) {
			
		}
		
		return answer;
	}
}
