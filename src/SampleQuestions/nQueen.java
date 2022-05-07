package SampleQuestions;

public class nQueen {

	public static void main(String[] args) {
		int n = 4;
		
		System.out.println(solution(n));
	}

	static int cnt;
    static int[] map;
	private static int solution(int n) {
		cnt = 0;
		map = new int[n];
        nQueen(0, n);
        
        return cnt;
	}
	
	private static void nQueen(int depth, int n) {
		if(depth == n) {  // 모두 배치
            cnt++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            map[depth] = i;
            
            if(isPossible(depth)) {
                nQueen(depth+1, n);
            }
        }
	}
	
	 private static boolean isPossible(int depth) {
	        for(int i = 0; i < depth; i++) {
	            // 세로 겹침
	            if(map[i] == map[depth]) {
	                return false;
	            }
	            
	            // 대각선 겹침
	            if(Math.abs(depth-i) == Math.abs(map[depth]-map[i])) {
	                return false;
	            }
	        }
	        
	        return true;
	    }

}
