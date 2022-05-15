package CodingTest0515;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution2 {

	public static void main(String[] args) {
//		int[] bricks = {1, 2, 5, 3, 1, 0, 2, 3};  // 벽돌이 놓인 지형의 모양을 나타내는 배열
//		int n = 6;  // 채우려는 물의 높이
//		int k = 3;  // 보여야 하는 물 웅덩이 개수
		
//		int[] bricks = {0, 1, 2, 3, 4};
//		int n = 5;
//		int k = 2;
		
//		int[] bricks = {0, 1, 2, 3, 4, 3};
//		int n = 5;
//		int k = 2;
		
//		int[] bricks = {5, 5, 2, 3, 2, 0};
//		int n = 5;
//		int k = 2;		
		
//		int[] bricks = {2, 4, 1, 3, 2, 4};
//		int n = 5;
//		int k = 3;		
		
//		int[] bricks = {4, 1, 1, 1, 4};
//		int n = 5;
//		int k = 3;	

		int[] bricks = {4, 1, 0, 0, 2, 3};
		int n = 5;
		int k = 3;	

//		int[] bricks = {4, 3, 4, 4, 2, 4};
//		int n = 5;
//		int k = 3;	

		System.out.println(solution(bricks, n, k));
	}


	private static int solution(int[] bricks, int n, int k) {
		int answer = 0;
		
		// 더 채워야 하는 블럭의 수 구하기
		ArrayList<Integer> rest = new ArrayList<>();
		boolean[] check = new boolean[bricks.length];
		
		for (int i = 0; i < bricks.length; i++) {
			rest.add(n-bricks[i]);
			if(bricks[i] == n) {
				check[i] = true;
			}
		}
		
		// 정렬
		Collections.sort(rest);
		
		int cnt = 0;
		for (int i = 0; i < rest.size(); i++) {
			if(rest.get(i) == 0) {
				continue;
			}
			
//			System.out.println(cnt);
			if(cnt==k-1) {
				break;
			}
			
//			for (int j = 1; j < bricks.length-1; j++) {
//				if(check[j] != true && check[j-1] != true && check[j+1] != true && n-bricks[j] == rest.get(i)) {
//					check[j] = true;
//					cnt++; 
//					answer += rest.get(i);
//					break;
//				}
//			}
			for (int j = bricks.length-2; j > 0; j--) {
				if(check[j] != true && check[j-1] != true && check[j+1] != true && n-bricks[j] == rest.get(i)) {
					check[j] = true;
					cnt++; 
					answer += rest.get(i);
					break;
				}
			}
			System.out.println(Arrays.toString(check));
		}
		
		return answer;
	}

}
