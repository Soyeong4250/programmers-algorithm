package DP;

public class expressIntoN {

	public static void main(String[] args) {
//		int N = 5;
//		int Number = 12;
		int N = 5;
		int Number = 12;
		System.out.println(solution(N, Number));
	}

	private static int solution(int N, int number) {
int min = 987654321;
        
        int sNumber = 0;
        int repeat = 0;
        
        while(true) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < repeat; i++) {
              sb.append(N);
            }
            sNumber = Integer.parseInt(sb.toString());
            int result = dp(N, number, sNumber, repeat);
            
            if(result > min) {
                break;
            }
            
            min = Math.min(min, result);
            
            repeat++;
        }
        
        int answer = min;
        
        if(min > 8) {
            answer = -1;
        }
        
        return answer;
    }
    
    public static int dp(int N, int number, int sum, int cnt) {
        if(sum == number) {
            return cnt;
        }
        
        dp(N, number, sum+N, cnt+1);
        dp(N, number, sum-N, cnt+1);
        dp(N, number, sum*N, cnt+1);
        dp(N, number, sum/N, cnt+1);
    }

}
