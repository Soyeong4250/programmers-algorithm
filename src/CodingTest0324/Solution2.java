package CodingTest0324;

public class Solution2 {  // 3, 4, 5, 9, 10, 15

	public static void main(String[] args) {
		// 1
//		int[] a = {1, 6};  // A의 외출 가능 시각
//		int[] b = {3, 5};  // B의 외출 가능 시각
//		int duration = 1;  // 두 사람이 약속 장소에서 보내는 시간을 나타내는 정수
//		int distance = 2;  // 두 사람의 집이 떨어진 거리를 나타내는 정수
		
		// 2
//		int[] a = {1, 6};  // A의 외출 가능 시각
//		int[] b = {2, 5};  // B의 외출 가능 시각
//		int duration = 1;  // 두 사람이 약속 장소에서 보내는 시간을 나타내는 정수
//		int distance = 3;  // 두 사람의 집이 떨어진 거리를 나타내는 정수
		
		// 3
//		int[] a = {1, 4};  // A의 외출 가능 시각
//		int[] b = {1, 4};  // B의 외출 가능 시각
//		int duration = 1;  // 두 사람이 약속 장소에서 보내는 시간을 나타내는 정수
//		int distance = 2;  // 두 사람의 집이 떨어진 거리를 나타내는 정수
		
		// 4
//		int[] a = {1, 50};  // A의 외출 가능 시각
//		int[] b = {51, 100};  // B의 외출 가능 시각
//		int duration = 100;  // 두 사람이 약속 장소에서 보내는 시간을 나타내는 정수
//		int distance = 100;  // 두 사람의 집이 떨어진 거리를 나타내는 정수

		int[] a = {1, 50};  // A의 외출 가능 시각
		int[] b = {48, 100};  // B의 외출 가능 시각
		int duration = 1;  // 두 사람이 약속 장소에서 보내는 시간을 나타내는 정수
		int distance = 100;  // 두 사람의 집이 떨어진 거리를 나타내는 정수

		System.out.println(solution(a, b, duration, distance));
	}

	private static int solution(int[] a, int[] b, int duration, int distance) {
		int answer = 0;  // 두 사람이 가장 빨리 만날 수 있는 시각
		int moveA = 0; // a가 움직인 거리
		int moveB = 0; // b가 움직인 거리
		
		if(a[0] < b[0]) { // a가 b보다 더 빨리 움직일 수 있다면
			distance -= (b[0] - a[0]);
			moveA += (b[0] - a[0]);
		}else if(b[0] < a[0]) {  // b보다 a가 더 빨리 움직일 수 있다면
			distance -= (a[0] - b[0]);
			moveB += (a[0] - b[0]);
		}
		
		// 남은 거리만큼 서로 움직이기
		moveA += distance/2;
		moveB += distance/2;
		
		if(a[0]+moveA*2+duration > a[1] || b[0]+moveB*2+duration > b[1]) {  // 출발시간 + 이동시간 + 함께 있던 시간이 도착시간보다 늦다면
			answer = -1;
		} else {
			if(a[0] < b[0]) {
				answer = a[0] + moveA;
			}else {
				answer = b[0] + moveB;
			}
		}
		
		return answer;
	}

}
