package lv2;

public class NextBigNumber {  // 다음 큰 숫자

	public static void main(String[] args) {
		int n = 78;
//		int n = 15;
		
		System.out.println(solution(n));
	}

	private static int solution(int n) {
		String b = Integer.toBinaryString(n);
		if(b.substring(b.length()-2).equals("01")) {
			return n+1;
		} else {
			int one = b.length() - b.replace(String.valueOf("1"), "").length();
			int tmp = 0;
			while(one != tmp) {
				n+=1;
				String str = Integer.toBinaryString(n);
				tmp = str.length() - str.replace(String.valueOf("1"), "").length();
			}
		}
		
		return n;
	}

}
