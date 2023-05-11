package FirstPackage;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
public class P178870 {
    public static int[] solution(int[] sequence, int k) {

        ArrayList<int[]> answer = new ArrayList<>();

        int[] sum = new int[sequence.length+1];
        for (int i=0; i<=sequence.length; i++) sum[i] = 0;
        for (int i=1; i<=sequence.length; i++) {
            sum[i] = sum[i-1] + sequence[i-1];
        }

        int left, right;
        left = 0;
        right = 1;

        while (right <= sequence.length) {
            int tmp = sum[right] - sum[left];

            if (tmp == k) {
                answer.add(new int[] {left, right-1, right-left});
                left += 1;
                right += 1;
            }
            else if (tmp < k) right += 1;
            else if (tmp > k) left += 1;
        }

        Collections.sort(answer, (x1, x2) -> (x1[2] - x2[2]));
        int[] dap = answer.get(0);
        return new int[] {dap[0], dap[1]};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1,2,3,4,5}, 7))); // [2,3]
        System.out.println(Arrays.toString(solution(new int[] {1,1,1,2,3,4,5}, 5))); // [6,6]
        System.out.println(Arrays.toString(solution(new int[] {2,2,2,2,2}, 6))); // [0,2]

    }
}
