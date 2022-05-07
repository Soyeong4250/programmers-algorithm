package DP;

public class integerTriangle {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		System.out.println(solution(triangle));
	}

	private static int solution(int[][] triangle) {
		 int[][] dp = new int[triangle.length][triangle.length];
	        
	        // for(int i=0; i<dp.length; i++) {
	        //     Arrays.fill(dp[i], 0);
	        // }
	        dp[0][0] = triangle[0][0];  // 초기값
	        
	        for(int i=1; i<triangle.length; i++) {
	            for(int j=0; j<triangle[i].length; j++) {
	                if(j==0 || j==triangle[i].length-1) {
	                    dp[i][j] = triangle[i-1][j] + triangle[i][j];  
	                } else {
	                    dp[i][j] = Math.max((triangle[i-1][j-1] + triangle[i][j]), (triangle[i-1][j] + triangle[i][j]));
	                }
	            }
	        }
	        
	        // 마지막 라인에서 max값 찾기
	        int answer = 0;
	        for(int i=0; i<triangle[triangle.length-1].length; i++) {
	            answer = Math.max(answer, triangle[triangle.length-1][i]);
	        }
	        return answer;
	}

}
