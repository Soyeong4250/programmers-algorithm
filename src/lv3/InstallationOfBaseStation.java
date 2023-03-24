package lv3;

import java.util.Arrays;

public class InstallationOfBaseStation { // 기지국 설치

	public static void main(String[] args) {
		InstallationOfBaseStation main = new InstallationOfBaseStation();

//		int N = 11;
//		int[] stations = { 4, 11 };
//		int W = 1;

		int N = 16;
		int[] stations = {9};
		int W = 2;

		System.out.println(main.solution(N, stations, W));
	}

	private int solution(int n, int[] stations, int w) {
		int answer = 0;
		
		boolean[] v = new boolean[n+1];
		
		for (int i = 0; i < stations.length; i++) {
			for (int j = 0; j <= w; j++) {
				if(stations[i] + j <= n) v[stations[i] + j] = true;
				if(0 < stations[i] - j) v[stations[i] - j] = true;
			}
//			System.out.println(Arrays.toString(v));
		}
		
		int cnt = 0;
		for (int i = 1; i < v.length; i++) {
			if (!v[i]) {
				cnt++;
				v[i] = true;
				if(i < v.length-1) continue;
			}
			answer += cnt / (w*2+1);
			if(cnt % (w*2+1) > 0) {
				answer += 1;
			}
			cnt = 0;
			System.out.println(Arrays.toString(v));
			System.out.println(answer);
		}
		
		return answer;
	}

}
