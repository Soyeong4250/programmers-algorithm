package lv3;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Point implements Comparable<Point> {
    int x;
    int y;
	
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
		
        return this.x - o.x;
    }
}

public class Puzzle {
	
    public static void main(String[] args) {
    	Puzzle main = new Puzzle();
        int[][] game_board = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, 
				{1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
        int[][] table = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, 
				{0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};
		
        System.out.println(main.solution(game_board, table));
    }
    
    static boolean[][] v;
    public int solution(int[][] game_board, int[][] table) {
        ArrayList<ArrayList<Point>> empty = new ArrayList<>();
        ArrayList<ArrayList<Point>> block = new ArrayList<>();
		
        v = new boolean[game_board.length][game_board.length];
		
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board.length; j++) {
                if (game_board[i][j] == 0 && !v[i][j]) {
                    empty.add(check(game_board, i, j, 0));
                }
            }
        }
		
        for (int i = 0; i < game_board.length; i++) {
            Arrays.fill(v[i], false);	
        }
		
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board.length; j++) {
                if (table[i][j] == 1 && !v[i][j]) {
                    block.add(check(table, i, j, 1));
                }
            }
        }
		
        boolean[] visitedBoard = new boolean[empty.size()];
        int answer = 0;
	
        for (int i = 0; i < block.size(); i++) {
            ArrayList<Point> blockCheck = block.get(i);
			
            for (int j = 0; j < empty.size(); j++) {
                ArrayList<Point> emptyCheck = empty.get(j);
				
                if (emptyCheck.size() == blockCheck.size() && !visitedBoard[j]) {
                    if (isRotate(emptyCheck, blockCheck)) {
                        answer += blockCheck.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }
        }
		
        return answer;
    }
	
    public boolean isRotate(ArrayList<Point> empty, ArrayList<Point> block) {
    	for (int i = 0; i < 4; i++) {
    		int zeroX = block.get(0).x;
    		int zeroY = block.get(0).y;
    		
    		for (int j = 0; j < block.size(); j++) {
    			block.get(j).x -= zeroX;
    			block.get(j).y -= zeroY;
    		}
    		
    		boolean isCollect = true;
    		
    		for (int j = 0; j < empty.size(); j++) {
    			Point emptyPoint = empty.get(j);
    			Point blockPoint = block.get(j);
    			
    			if (emptyPoint.x != blockPoint.x || emptyPoint.y != blockPoint.y) {
    				isCollect = false;
    				break;
    			}
    		}
    		
    		if (isCollect) {
    			return true;
    		}
    		else {
    			for (int j = 0; j < block.size(); j++) {
    				int temp = block.get(j).x;
    				
    				block.get(j).x = block.get(j).y;
    				block.get(j).y = -temp;
    			}
    			
    			Collections.sort(block);
    		}
    		
    	}
    	
    	return false;
    }
    
    public ArrayList<Point> check(int[][] game_board, int x, int y, int type) {
        int[] dx = {-1, 0 , 1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<Point> q = new LinkedList<>();
        ArrayList<Point> result = new ArrayList<>();
		
        q.add(new Point(x, y));
        v[x][y] = true;
		
        result.add(new Point(0, 0));
		
        while (!q.isEmpty()) {
            Point cur = q.poll();
			
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
				
                if (nx >= 0 && nx < game_board.length && ny >= 0 && ny < game_board.length) {
                    if (!v[nx][ny] && game_board[nx][ny] == type) {
                        q.add(new Point(nx, ny));
                        v[nx][ny] = true;
                        result.add(new Point(nx - x, ny - y));
                    }
                }
				
            }
        }
		
        Collections.sort(result);
		
        return result;
    }
	
	
=======
public class Puzzle {

	public static void main(String[] args) {
		Puzzle main = new Puzzle();
		
		int[][] game_board = {{1,1,0,0,1,0}, {0,0,1,0,1,0}, {0,1,1,0,0,1}, {1,1,0,1,1,1}, {1,0,0,0,1,0}, {0,1,1,1,0,0}};
		int[][] table = {{1,0,0,1,1,0}, {1,0,1,0,1,0}, {0,1,1,0,1,1}, {0,0,1,0,0,0}, {1,1,0,1,1,0}, {0,1,0,0,0,0}};
//		int[][] game_board = {{1,1,0,0,1,0}, {0,0,1,0,1,0}, {0,1,1,0,0,1}, {1,1,0,1,1,1}, {1,0,0,0,1,0}, {0,1,1,1,0,0}};
//		int[][] table = {{1,0,0,1,1,0}, {1,0,1,0,1,0}, {0,1,1,0,1,1}, {0,0,1,0,0,0}, {1,1,0,1,1,0}, {0,1,0,0,0,0}};
		
		System.out.println(main.solution(game_board, table));
	}

	private int solution(int[][] game_board, int[][] table) {
		int answer = 0;
		
		int[] dr = {0, 1, 0, -1};  // → ↓ ← ↑
		int[] dc = {1, 0, -1, 0};  // → ↓ ← ↑
		
		
		int[][] select = new int[table.length][table[0].length];
		// 도형 고르기
		selectShape(table, select, 0, 0);
		
		
		return answer;
	}

	private void selectShape(int[][] table, int[][] select, int i, int j) {
		
	}

>>>>>>> Stashed changes
}
