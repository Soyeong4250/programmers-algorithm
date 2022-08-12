package lv2;

import java.util.StringTokenizer;

public class SearchRank { // 순위 검색

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", 
						"python frontend senior chicken 210",
						"python frontend senior chicken 150", 
						"cpp backend senior pizza 260", 
						"java backend junior chicken 80",
						"python backend senior chicken 50" };
		String[] query = {"java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200",
						"cpp and - and senior and pizza 250",
						"- and backend and senior and - 150",
						"- and - and - and chicken 100",
						"- and - and - and - 150"};
		
		System.out.println(solution(info, query));
	}

	static class Info {
		String lang;
		String job;
		String exp;
		String food;
		int score;
		
		public Info(String lang, String job, String exp, String food, int score) {
			this.lang = lang;
			this.job = job;
			this.exp = exp;
			this.food = food;
			this.score = score;
		}
	}
	
    private static int[] solution(String[] info, String[] query) {
    	int[] answer = new int[query.length];
    	
    	Info[] people = new Info[info.length];
    	
    	for (int i = 0; i < query.length; i++) {
			StringTokenizer st = new StringTokenizer(info[i]);
			while(st.hasMoreTokens()) {
				if(st.nextToken().equals("and")) {
					continue;
				}else {
					Info.lang
				}
			}
			
		}
    	
    	
    	
    	return answer;
    }

}
