package FirstPackage;

import java.util.PriorityQueue;
public class P135808 {

    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        int N = score.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            heap.add(-1 * score[i]);
        }

        while (heap.size() >= m) {
            for (int i=1; i<m; i++) heap.poll();
            int min = -1 * heap.poll();
            answer += min*m;
        }

        return answer;
    }

}
