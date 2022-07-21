package lv2;

public class UnscathedRectangle {  // 멀쩡한 사각형

	public static void main(String[] args) {
//		int W = 8;
//		int H = 12;
		int W = 6;
		int H = 9;
		
		System.out.println(solution(W, H));
	}
	
	private static long solution(int W, int H) {
		long answer = 0;
		
		int divisor = 0;
		
		answer = W*H-(W+H-greatestNum(W, H, 0));
		
		return answer;
	}
	
	// 최대공약수 구하기
	private static int greatestNum(int w , int h, int divisor) {
		for (int i = 1; i <= w; i++) {
			if(w%i==0 && h%i==0) {
				 if(divisor < i) {
					 divisor = i;
				 }
			}
		}
		
		return divisor;
	}

}
