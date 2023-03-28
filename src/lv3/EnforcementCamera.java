package lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class EnforcementCamera { // 단속 카메라

	public static void main(String[] args) {
		EnforcementCamera main = new EnforcementCamera();
//		int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		int[][] routes = { { -20, -14 }, { -18, -17 }, { -15, -5 }, { -4, -3 } };

		System.out.println(main.solution(routes));
	}

	private int solution(int[][] routes) {
		int cnt = 0;
		
		Arrays.sort(routes, (s1, s2) -> s1[0] != s2[0] ? s1[0] - s2[0] : s1[1] - s2[1]);
		
		for (int i = 0; i < routes.length; i++) {
			System.out.println(Arrays.toString(routes[i]));			
		}
		
		return checkCnt(routes);
	}

	private int checkCnt(int[][] routes) {
		int result = 0;
		
		boolean[] check = new boolean[routes.length];
		for (int i = 0; i < routes.length; i++) {
			if(check[i]) continue;
			int spot = routes[i][1];
			check[i] = true;
			boolean flag = false;
			for (int j = i+1; j < routes.length; j++) {
				if(i == j) continue;
				if(check[j]) continue;
				if(routes[j][0] <= spot && spot <= routes[j][1]) {
					check[j] = true;
					flag = true;
				}
			}
			if(flag) result++;
		}
		
		System.out.println(Arrays.toString(check));
		return result;
	}

}
