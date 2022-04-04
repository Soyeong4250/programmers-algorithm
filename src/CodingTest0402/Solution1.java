package CodingTest0402;

import java.util.ArrayList;
import java.util.List;

public class Solution1 { 

	public static void main(String[] args) {
		int[][] dist = {{0,5,2,4,1},{5,0,3,9,6},{2,3,0,6,3},{4,9,6,0,3},{1,6,3,3,0}};  // result = [{1,2,0,4,3],{3,4,0,2,1]]
//		int[][] dist = {{0,2,3,1},{2,0,1,1},{3,1,0,2},{1,1,2,0}};  // result = [[0,3,1,2],[2,1,3,0]]
		System.out.println(solution(dist));
		
	}

	private static int[][] solution(int[][] dist) {
		int max = 0;
		int spot = 0;
		boolean[] check = new boolean[dist.length];
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < dist.length; i++) {
			int sum = 0;
			for (int j = 0; j < dist[i].length; j++) {
				sum += dist[i][j];
			}
			if(max < sum) {  // 가장 거리가 긴 점 구하기
				max = sum;
				spot = i;
			}
		}
		result.add(spot);
		check[spot] = true;
		
		while(true) {
			int min = 1000;
			int tmp = 0;
			for (int i = 0; i < dist[spot].length; i++) {
//				System.out.println("지금의 spot은 " + spot + ", 지금의 i는 " + i + ", 거리는 " + dist[spot][i]);
				if(i!=spot && check[i]==false && dist[spot][i] < min) {  // 가장 가까운 거리의 점이면
					min = dist[spot][i];
					tmp = i;
				}
			}
			spot = tmp;
//			System.out.println("list에 추가합니다" + spot + ", min값은 " + min);
			result.add(spot);
			check[spot] = true;
			
			if(result.size() == dist.length) {
				break;
			}
		}
	
//		System.out.println(result);
		int[][] answer = new int[2][result.size()];
		if(result.get(0) < result.get(result.size()-1)) {
			for (int i = 0; i < result.size(); i++) {
				answer[0][i] = result.get(i);
			}
			for (int i = result.size()-1; i >= 0; i--) {
				answer[1][result.size()-1-i] = result.get(i);
			}
		}else {
			for (int i = 0; i < result.size(); i++) {
				answer[1][i] = result.get(i);
			}
			for (int i = result.size()-1; i >= 0; i--) {
				answer[0][result.size()-1-i] = result.get(i);
			}
		}
		
//		for (int i = 0; i < answer.length; i++) {
//			System.out.println(Arrays.toString(answer[i]));			
//		}
		return answer;
	}

}
