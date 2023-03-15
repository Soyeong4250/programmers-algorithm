package lv2;

import java.util.Arrays;
import java.util.HashSet;

public class WordChangeGame { // 영어 끝말잇기

	public static void main(String[] args) {
		WordChangeGame main = new WordChangeGame();

//		int n = 3;
//		String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };

//		int n = 5;
//		String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};

//		int n = 2;
//		String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

		int n = 2;
		String[] words = {"o", "one", "even", "never", "now", "world", "draw"};

		System.out.println(Arrays.toString(main.solution(n, words)));
	}

	private int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		HashSet<String> memo = new HashSet<String>();
		
		for (int i = 0; i < words.length; i++) {
			if(i > 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
				answer[0] = i%n+1;
				answer[1] = i/n+1;
				break;
			}else if(memo.contains(words[i])) {
				answer[0] = i%n+1;
				answer[1] = i/n+1;
				break;
			}else if(words[i].length() == 1) {
				answer[0] = i%n+1;
				answer[1] = i/n+1;
				break;
			}
			memo.add(words[i]);
		}
		
		return answer;
	}

}
