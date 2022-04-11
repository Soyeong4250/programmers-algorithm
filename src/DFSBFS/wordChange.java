package DFSBFS;

public class wordChange { // 단어 변환

	public static void main(String[] args) {

		String begin = "hit";
		String target = "cog";
//		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		String [] words = {"hot", "dot", "dog", "lot", "log"};

		System.out.println(solution(begin, target, words));
	}

	static int answer = 0;
	private static int solution(String begin, String target, String[] words) {
		
		dfs(begin, target, words, new boolean[words.length], 0);

		return answer;
	}

	private static void dfs(String begin, String target, String[] words, boolean[] v, int result) {
		if(begin.equals(target)) {  // 기저조건
//			System.out.println(result + "단계를 거쳐 도착했습니다.");
			answer = result;
			return;
		}
		
		for (int i = 0; i < words.length; i++) {
			if(v[i]) {  // 이미 방문한 words면 pass
				continue;
			}
			
			int cnt = 0;  // 스펠링이 몇개가 같은지 개수 세기
			for (int j = 0; j < begin.length(); j++) {
				if(begin.charAt(j) == words[i].charAt(j)) {
					cnt++;
//					System.out.println(begin.charAt(j) + "스펠링이 같고 cnt는 " + cnt);
				}
			}
			
			if(cnt == begin.length()-1) {  // 단어가 한글자 빼고 같다면 다음 단어 탐색
				v[i] = true;
				dfs(words[i], target, words, v, result+1);
				v[i] = false;
			}
		}
		
	}

}
