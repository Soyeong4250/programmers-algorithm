package CodingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {
	class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
//		int n = 5;
//		int[][] edge = {{0, 1},
//					  {0, 2},
//					  {1, 3},
//					  {1, 4}};
		
		int n = 4;
		int[][] edge = {{2, 3},
						{0, 1},
						{1, 2}};
					  
		System.out.println(solution(n, edge));
	}

	static int answer = 0;
	private static long solution(int n, int[][] edge) {
		
		Node[] node = new Node[edge.length];
		for (int i = 0; i < edge.length; i++) {
			for (int j = 0; j < edge[i].length; j++) {
				node[i].x = edge[i][0];
				node[i].y = edge[i][1];
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				tree(node, i, j, new boolean[n], 0);				
			}
		}
		
		
		return (long)answer;
		
	}
	
	private static void tree(Node[] node, int start, int end, boolean v[], int cnt) {
		if(cnt == 3) {
			System.out.println(Arrays.toString(v));
			return;
		}
		
		for (int i = 0; i < node.length; i++) {
			
		}
	}

	
}

