package lv2;

import java.util.Arrays;
import java.util.Iterator;

public class PaintOver { // 덧칠하기

	public static void main(String[] args) {
		PaintOver main = new PaintOver();

		int n = 8;
		int m = 4;
		int[] section = { 2, 3, 6 };
//		int n = 5;
//		int m = 4;
//		int[] section = {1, 3};
//		int n = 4;
//		int m = 1;
//		int[] section = {1, 2, 3, 4};

		System.out.println(main.solution(n, m, section));
	}

	private int solution(int n, int m, int[] section) {
		int cnt = 0;
		
		int idx = 0;
		for (int i : section) {
			if(idx < i) {
				idx = i+m-1;
				cnt += 1;
			}
		}
		
		return cnt;
	}

}
