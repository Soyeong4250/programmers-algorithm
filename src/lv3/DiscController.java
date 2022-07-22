package lv3;

import java.util.Arrays;
import java.util.Comparator;

public class DiscController {  // 디스크 컨트롤러

	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution(jobs));
	}

	private static int solution(int[][] jobs) {
		int answer = 0;
		
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1]-o2[1]; 
				}
				return o1[0]-o2[0];
			}
		});
		
		int pre = 0;
		for(int i=0; i<jobs.length; i++) {
			answer += (jobs[i][1] + pre -jobs[i][0]);
			pre += jobs[i][1];
		}
		
		return answer/3;
	}
}
