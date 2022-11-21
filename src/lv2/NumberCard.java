package lv2;

public class NumberCard {

	private int solution(int[] arrayA, int[] arrayB) {
		int chulsu = arrayA[0];
		
		if(arrayA.length > 1) {
			for (int i = 1; i < arrayA.length; i++) {
				chulsu = gcd(chulsu, arrayA[i]);
			}
		}
		
		int yeonghui = arrayB[0];
		
		if(arrayB.length > 1) {
			for (int i = 1; i < arrayB.length; i++) {
				yeonghui = gcd(yeonghui, arrayB[i]);
			}
		}
		
//		System.out.println(chulsu + ", " + yeonghui);
		for (int i = 0; i < arrayA.length; i++) {
			if(chulsu != 0 && arrayB[i] % chulsu == 0) {
				chulsu = 0;
			}
			if(yeonghui != 0 && arrayA[i] % yeonghui == 0) {
				yeonghui = 0;
			}
		}
		
		return Math.max(chulsu, yeonghui);
	}
	
	private int gcd(int small, int big) {
			
		if(small > big) {
			int temp = small;
			small = big;
			big = temp;
		}
		
//		System.out.println(big + ", " + small);
		if(small == 0) {
			return big;
		}else {
			return gcd(small, big%small);
		}
	}
	
	public static void main(String[] args) {
		NumberCard main = new NumberCard();
		
		// result = 0
		int[] arrayA = {10, 17};
		int[] arrayB = {5, 20};
		
		// result = 10
		/*int[] arrayA = {10, 20};
		int[] arrayB = {5, 17};*/

		// result = 7
		/*int[] arrayA = {14, 35, 119};
		int[] arrayB = {18, 30, 102};*/
		
		/*int[] arrayA = {10, 30};
		int[] arrayB = {5, 10, 39};*/
		
		System.out.println(main.solution(arrayA, arrayB));
	}


}
