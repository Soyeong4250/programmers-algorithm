package lv2;

public class Joystick {  // 조이스틱

	public static void main(String[] args) {
//		String name = "JEROEN";
//		String name = "JAZ";
//		String name = "JAN";
//		String name = "AAB";
		String name = "ABABAAAAABA";
		
		Joystick joystick = new Joystick();
		System.out.println(joystick.solution(name));
	}

	private int solution(String name) {
		int startA = -1;
		int endA = -1;
		boolean continuous = true;
		char[] alphabet = new char[name.length()];
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = name.charAt(i);
			if(startA == -1 && alphabet[i] == 'A') {
				startA = i-1;
			}else if(startA != -1 && endA == -1 && alphabet[i] != 'A') {
				endA = i-1;
			} else if(startA != -1 && endA != -1 && alphabet[i] == 'A') {
				continuous = false;
			}
		}
		
		int moveCnt = -1; 
		if(continuous) {
			moveCnt = minMoveCnt(name.length() - 1, startA, endA);
		} else {
			moveCnt = name.length() - 1;
		}
		
		int changeCnt = changeAlphabet(alphabet);
		
//		System.out.println(changeCnt);
		return moveCnt + changeCnt;
	}

	private int minMoveCnt(int min, int startA, int endA) {
		if(startA != -1 && endA != -1) {
//			System.out.println(startA * 2 + min-endA);
//			System.out.println((min-endA)*2 + startA);
			min = Math.min(startA * 2 + min-endA, (min-endA)*2 + startA);
		}
		
		return min;
	}

	private int changeAlphabet(char[] alphabet) {
		int cnt = 0;
		
		for (int i = 0; i < alphabet.length; i++) {
			cnt += Math.min(alphabet[i] - 'A', 'Z' - alphabet[i] + 1);
//			System.out.println("cnt = " + cnt);
		}
		
		return cnt;
	}

}
