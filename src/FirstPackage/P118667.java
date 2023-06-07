package FirstPackage;

import java.util.ArrayDeque;

public class P118667 {
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        ArrayDeque<Integer> deque2 = new ArrayDeque<>();
        long sum1, sum2, target;
        int size;
        sum1 = 0;
        sum2 = 0;
        size = queue1.length + queue2.length;
        for (int i=0; i<queue1.length; i++) {
            deque1.add(queue1[i]);
            sum1 += queue1[i];
        }
        for (int i=0; i<queue2.length; i++) {
            deque2.add(queue2[i]);
            sum2 += queue2[i];
        }

        if (sum1 + sum2 % 2 == 1) return -1;
        target = (sum1 + sum2) / 2;

        while (true) {

            if (sum1 == target) break;
            if (answer > size * 2) {
                answer = -1;
                break;
            }
            if (sum1 > target) {
                int number = deque1.poll();
                sum1 -= number;
                deque2.add(number);
                answer += 1;
            }
            if (sum1 < target) {
                int number = deque2.poll();
                sum1 += number;
                deque1.add(number);
                answer += 1;
            }
        }

        return answer;

    }
}
