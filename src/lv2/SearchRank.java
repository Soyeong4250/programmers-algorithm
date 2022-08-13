package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    	
    	for (int i = 0; i < info.length; i++) {
			StringTokenizer st = new StringTokenizer(info[i]);
			Info p = new Info(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()));
			people[i] = p;
		}
    
//    	String[] arr = query[0].split(" and | ");

    	List<Info> list = new ArrayList<>();
    	for (int i = 0; i < query.length; i++) {
			String[] arr = query[i].split(" and | ");
			Info q = new Info(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]));
			
			list.add(q);
		}
    	
    	for (int i=0; i<list.size(); i++) {
    		Info q = list.get(i);
			for (int j = 0; j < people.length; j++) {
				if((q.lang.equals("-") || q.lang.equals(people[j].lang)) && (q.job.equals("-") || q.job.equals(people[j].job)) && 
						(q.exp.equals("-") || q.exp.equals(people[j].exp)) && (q.food.equals("-") || q.food.equals(people[j].food)) && q.score <= people[j].score) {
					answer[i]++;
				}
			}
		}
    	
    	
    	System.out.println(Arrays.toString(answer));
    	return answer;
    }

}
