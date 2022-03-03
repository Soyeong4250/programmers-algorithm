package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Truck { // 다리를 지나는 트럭

	public static void main(String[] args) {
//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = { 7, 4, 5, 6 };
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10};

		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	private static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;  //  걸린 시간
		
		Queue<Integer> bridge = new LinkedList<>();  // 다리 위에 있는 트럭
		int sum = 0;  // 다리 위의 트럭 총 무게
		
		for (int i = 0; i < truck_weights.length; i++) {
			int truck = truck_weights[i];
			
			while(true) {
				if(bridge.isEmpty()) {  // 빈 다리에 새로운 트럭이 다리를 건너는 경우 (처음)
					bridge.add(truck);
					answer += 1;
					sum += truck;
					break;
				}
				else if(bridge.size() < bridge_length) { // 다리에 트럭이 1대 있는 경우
					if(sum + truck <= weight) {  // 새로운 트럭이 올라갔을 때 무게를 버틸 수 있다면
						bridge.add(truck);
						answer += 1;
						sum += truck;
						break;
					}else {  // 새로운 트럭이 올라갔을 때 무게를 버틸 수 없다면
						bridge.add(0);  // 0의 무게의 트럭이 들어갔다고 생각하기
						answer += 1;
					}
				} else {  // 다리에 이미 트럭이 다 찬 경우
					sum -= bridge.poll();
				}
			}
		}
		
		// 마지막 트럭까지 다리를 모두 지나가게 하기
		answer += bridge_length;
		return answer;
	}

}
