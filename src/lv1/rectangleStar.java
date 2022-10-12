package lv1;

import java.util.Scanner;
import java.util.stream.IntStream;

public class RectangleStar {  // 직사각형 별찍기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("*");
			}System.out.println();
		}
	}

}
