package lv3;

import java.util.Arrays;

public class InstallationOfBaseStation { // 기지국 설치

	public static void main(String[] args) {
		InstallationOfBaseStation main = new InstallationOfBaseStation();

//		int N = 11;
//		int[] stations = { 4, 11 };
//		int W = 1;

//		int N = 16;
//		int[] stations = {9};
//		int W = 2;

//		int N = 13;
//		int[] stations = {3, 7, 11};
//		int W = 1;

//		int N = 5;
//		int[] stations = {3};
//		int W = 2;
		
//		int N = 6;
//		int[] stations = {3};
//		int W = 2;
		
//		int N = 16;
//		int[] stations = {1, 16};
//		int W = 2;

//		int N = 6;
//		int[] stations = {4};
//		int W = 2;

//		int N = 11;
//		int[] stations = {1, 4};
//		int W = 1;

//		int N = 11;
//		int[] stations = {1, 5};
//		int W = 1;
		
//		int N = 5;
//		int[] stations = {1, 2, 3, 4, 5};
//		int W = 0;
		
		int N = 200000000;
		int[] stations = {100000000};
		int W = 5;

		System.out.println(main.solution(N, stations, W));
	}

	private int solution(int n, int[] stations, int w) {
		int answer = 0;
		
		int start = 1;
		int end = 1;
		
		for (int i = 0; i < stations.length; i++) {
			end = 0 < (stations[i] - w) ? stations[i] - w : start;
			
			int cnt = end - start;
			System.out.println("end = " + end);
			System.out.println("start = " + start);
			System.out.println("cnt = " + cnt);
			
			answer += cnt / (w*2+1);
			if(cnt % (w*2+1) != 0) answer++;
			
			start = stations[i] + w + 1;
			System.out.println(start);
		}
		
		end = n+1;
		if(end - start > 0) {
			System.out.println("end = " + end);
			answer += (end - start) / (w*2+1);
			if((end - start) % (w*2+1) != 0) answer++;
		}
		
		return answer;
	}

}
