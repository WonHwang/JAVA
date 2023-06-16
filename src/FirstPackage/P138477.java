package FirstPackage;

import java.util.PriorityQueue;
import java.util.Arrays;
public class P138477 {

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i=0; i<score.length; i++) {
            if (heap.size() < k) {
                heap.add(score[i]);
                answer[i] = heap.peek();
            }
            else {
                if (heap.peek() < score[i]) {
                    heap.poll();
                    heap.add(score[i]);
                    answer[i] = heap.peek();
                }

                else {
                    answer[i] = heap.peek();
                }
            }
        }
        return answer;
    }
}
