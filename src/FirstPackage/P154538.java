package FirstPackage;

import java.util.Deque;
import java.util.ArrayDeque;
public class P154538 {

    public static int solution(int x, int y, int n) {
        int answer = 0;
        int[] numbers = new int[1000001];

        Deque<Integer> queue = new ArrayDeque<>();
        numbers[x] = 1;
        queue.add(x);

        while (!queue.isEmpty()) {
            int number = queue.poll();
            int step = numbers[number];
            int next;

            next = number + n;
            if (next < 1000001 && numbers[next] == 0) {
                numbers[next] = step+1;
                queue.add(next);
            }

            next = number * 2;
            if (next < 1000001 && numbers[next] == 0) {
                numbers[next] = step+1;
                queue.add(next);
            }

            next = number * 3;
            if (next < 1000001 && numbers[next] == 0) {
                numbers[next] = step+1;
                queue.add(next);
            }
        }

        answer = numbers[y] - 1;

        return answer;
    }
}
