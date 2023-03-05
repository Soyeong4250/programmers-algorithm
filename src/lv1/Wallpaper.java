package lv1;

import java.util.Arrays;

public class Wallpaper { // 바탕화면 정리

	public static void main(String[] args) {
		Wallpaper main = new Wallpaper();
//		String[] wallpaper = { ".#...", "..#..", "...#." };
//		String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
//		String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
		String[] wallpaper = {"..", "#."};

		long start = System.currentTimeMillis();
		int[] answer = main.solution(wallpaper);
		long end = System.currentTimeMillis();
		System.out.println("solution() 실행 시간 : " + (end - start));
		System.out.println(Arrays.toString(answer));
	}

	private int[] solution(String[] wallpaper) {
		int[] answer = new int[4];
		Arrays.fill(answer, -1);
		
		for (int i = 0; i < wallpaper.length; i++) {
			for (int j = 0; j < wallpaper[i].length(); j++) {
				if(wallpaper[i].charAt(j) == '#') {
					if(answer[0] == -1 && answer[1] == -1 && answer[2] == -1 && answer[3] == -1) {
						answer[0] = i;
						answer[1] = j;
						answer[2] = i+1;
						answer[3] = j+1;
					}else {
						answer[0] = Math.min(i, answer[0]);
						answer[1] = Math.min(j, answer[1]);
						answer[2] = Math.max(i+1, answer[2]);
						answer[3] = Math.max(j+1, answer[3]);
					}
				}
			}
		}
		
		return answer;
	}

}
