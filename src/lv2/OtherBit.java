package lv2;

import java.util.Arrays;

public class OtherBit {  // 2개 이하로 다른 비트
    public static void main(String[] args) {
        OtherBit main = new OtherBit();

        // [3, 11]
        int[] numbers = {2, 7};

        System.out.println(Arrays.toString(main.solution(numbers)));
    }

    // 10, 11 시간 초과
    /*private long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int t = 0; t < numbers.length; t++) {
            // String binary = Long.toBinaryString(numbers[t]);
            System.out.println(numbers[t]);

            int cnt = 0;
            int i = 1;
            while (true) {
                // String otherBinary = Long.toBinaryString(numbers[t] + i);
                String result = Long.toBinaryString(numbers[t] ^ (numbers[t] + i));
                cnt = result.replaceAll("0", "").length();
                if(0 < cnt && cnt <= 2) {
                    answer[t] = numbers[t] + i;
                    break;
                } else {
                    i += 1;
                }
            }
        }

        return answer;
    }*/

    
}
