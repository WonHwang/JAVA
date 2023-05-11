package FirstPackage;

import java.util.Arrays;

public class P181188 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{4, 5}, {4, 8},{10,14},{11,13}, {5,12},{3, 7}, {1, 4}}));
    }

    public static int solution(int[][] targets) {
        Arrays.sort(targets, (x1, x2) -> (x1[1] - x2[1]));
        int answer = 0;
        double p = targets[0][1] - 0.5;
        for (int i=1; i<targets.length; i++) {
            if (p < targets[i][0] || p > targets[i][1]) {
                answer += 1;
                p = targets[i][1] - 0.5;
            }
        }
        answer += 1;
        return answer;
    }
}
