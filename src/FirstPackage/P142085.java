package FirstPackage;

import java.util.PriorityQueue;
public class P142085 {

    public int solution (int n, int k, int[] enemy) {
        int N = enemy.length;
        int[] dp = new int[N];
        for (int i=0; i<N; i++) dp[i] = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(enemy[0]);
        dp[0] = enemy[0];
        int answer = N;

        int sum = enemy[0];
        for (int i=1; i<N; i++) {
            int num = enemy[i];

            if (heap.size() < k) {
                sum += num;
                heap.add(num);
            }

            else {
                int min = heap.poll();

                if (min < num) {
                    sum -= min;
                    sum += num;
                    heap.add(num);
                }
                else heap.add(min);
            }

            dp[i] = dp[i-1] + enemy[i];

            if (dp[i] - sum > n) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
