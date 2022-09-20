package lv2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Carpet {  // 카펫
	static class Info {
		int height;
		int width;
		
		public Info(int height, int width) {
			this.height = height;
			this.width = width;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
//		int brown = 10;
//		int yellow = 2;
//		int brown = 8;
//		int yellow = 1;
		int brown = 24;
		int yellow = 24;
		
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}
	
	private static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		ArrayList<Info> info = new ArrayList<>();
		
		int yh = 1;
		int yw = yellow/yh;
		while(yh <= yw) {
			info.add(new Info(yh, yw));
			yh += 1;
			yw = yellow/yh;
		}
		
//		for (Info i : info) {
//			System.out.println(i.height + ", " + i.width);
//		}
		
		for (int i = 0; i < info.size(); i++) {
			if((info.get(i).width + 2)*2 + info.get(i).height*2 == brown) {
				answer[0] = info.get(i).width+2;
				answer[1] = info.get(i).height+2;
			}
		}
		
//		System.out.println(Arrays.toString(answer));
		return answer;
	}

}
