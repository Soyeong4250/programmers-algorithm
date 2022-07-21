package lv2;

public class UnscathedRectangle {  // 멀쩡한 사각형

	public static void main(String[] args) {
		int W = 8;
		int H = 12;
//		int W = 6;
//		int H = 9;
		
		System.out.println(solution(W, H));
	}
	
	private static long solution(int W, int H) {
		long answer = 0;
		
		answer = W*H-(W+H-greatestNum(W, H));
		
		return answer;
	}
	
	// 최대공약수 구하기 (유클리드 호제법 : a와 b의 최대공약수는 b와 r의 최대공약수와 같다 (a>b, r은 a를 b로 나눈 나머지))
	private static int greatestNum(int w , int h) {
		
		int s = Math.min(w, h);
		int b = Math.max(w, h);
		int r = 0;  // 나머지
		
		while(s > 0) {
			r = b%s;
			b  = s;
			s = r;
		}
		
		return b;
	}

}
