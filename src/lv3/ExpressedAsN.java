package lv3;

public class ExpressedAsN { // N으로 표현

	public static void main(String[] args) {
		int N = 5;
		int number = 12;

//		int N = 2;
//		int number = 11;

		System.out.println(solution(N, number));
	}

	static int answer;
    private static int solution(int N, int number) {
        //모든 최솟값이 8보다 커서 dfs가 return 되는 경우는 답이 -1
        answer = -1;
        
         dfs(N, number, 0, 0);
        
        return answer;
    }
    
    private static void dfs(int N, int number, int sum, int count){
        if(count > 8) return;
        
        if(sum == number){
            if(count < answer || answer == -1) answer = count;
            return;
        }
        //새로운 DFS를 탈 때 tmpN을 초기화시켜줌으로써 N, NN, NNN 등을 탐색할 수 있다
        int tmpN = 0;
        for(int i=1; i<9; i++){
            tmpN = tmpN*10 + N;
            dfs(N, number, sum+tmpN, count+i);
            dfs(N, number, sum-tmpN, count+i);
            dfs(N, number, sum*tmpN, count+i);
            dfs(N, number, sum/tmpN, count+i);
        }
        
    }

}
