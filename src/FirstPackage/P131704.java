package FirstPackage;

import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;
public class P131704 {

    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> queue = new ArrayDeque<>();

        int N = order.length;
        for (int i=1; i<=N; i++) queue.add(i);

        for (int i=0; i<N; i++) {
            int num = order[i];
            boolean flag = true;

            while (true) {
                if (!queue.isEmpty() && queue.element() == num) {
                    queue.poll();
                    answer += 1;
                    break;
                }

                if (!stack.isEmpty() && stack.peek() == num) {
                    stack.pop();
                    answer += 1;
                    break;
                }

                if (!queue.isEmpty() && queue.element() < num) {
                    stack.add(queue.poll());
                }

                else {
                    flag = false;
                    break;
                }
            }

            if (!flag) break;
        }

        return answer;
    }
}
