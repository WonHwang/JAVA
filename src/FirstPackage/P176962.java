package FirstPackage;

import java.util.Arrays;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class P176962 {

    public static String[] solution(String[][] plans) {

        ArrayList<String> answer = new ArrayList<>();

        for (int i=0; i<plans.length; i++) {
            String[] tmp = plans[i][1].split(":");
            String time = Integer.toString(Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]));
            plans[i][1] = time;
        }
        Arrays.sort(plans, (x1, x2) -> (Integer.parseInt(x1[1]) - Integer.parseInt(x2[1])));

        Stack<String[]> stack = new Stack<>();
        Queue<String[]> queue = new ArrayDeque<>();

        for (int i=0; i<plans.length; i++) queue.add(plans[i]);
        int time = 0;
        while (!queue.isEmpty()) {

            if (time == Integer.parseInt(queue.element()[1])) {
                stack.add(queue.poll());
            }

            if (!stack.isEmpty()) {
                stack.peek()[2] = Integer.toString(Integer.parseInt(stack.peek()[2]) - 1);
                if (Integer.parseInt(stack.peek()[2]) == 0) {
                    answer.add(stack.pop()[0]);
                }
            }

            time += 1;
        }

        while (!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }

        String[] answer_ = new String[answer.size()];
        for (int i=0; i<answer_.length; i++) {
            answer_[i] = answer.get(i);
        }
        return answer_;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}})));
    }
}
