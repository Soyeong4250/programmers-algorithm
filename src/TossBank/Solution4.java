package TossBank;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution4 {

	public static void main(String[] args) {
		String s = "2021:04:12:16:08:35"; // 첫 저축을 시작한 시각
		String[] times = { "01:06:30:00", "01:04:12:00" }; // 다음 저축까지 걸린 기간

		System.out.println(solution(s, times));
	}

	private static int[] solution(String s, String[] times) {
		int[] answer = {}; // 저축 성공 여부(1/0), 저축 기간

		SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd:hh:MM:ss");

		try {
			Calendar cal = Calendar.getInstance();
			Date FirstDate = format.parse(s);
			cal.setTime(FirstDate);
			for (int i = 0; i < times.length; i++) {

				cal.add(Calendar.DATE, +Integer.parseInt(times[i].substring(0, 1)));
				cal.add(Calendar.HOUR, +Integer.parseInt(times[i].substring(3, 4)));
				cal.add(Calendar.MINUTE, +Integer.parseInt(times[i].substring(6, 7)));
				cal.add(Calendar.SECOND, +Integer.parseInt(times[i].substring(9, 10)));
				// TODO Auto-generated catch block
				String resultDate = format.format(cal.getTime());
				System.out.println(resultDate);
			}
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}


		return answer;
	}

}
