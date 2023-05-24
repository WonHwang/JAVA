package FirstPackage;

import java.util.List;
import java.util.ArrayList;

public class P134239 {

    public static double[] solution(int k, int[][] ranges) {
        double[] answer = {};

        List<Integer> graphs = new ArrayList<>();
        int cnt = 1;
        graphs.add(k);

        while (k != 1) {
            if (k%2 == 1)
                k = 3*k + 1;
            else
                k /= 2;
            cnt += 1;
            graphs.add(k);
        }

        int N = graphs.size();

        double[] integral = new double[N];

        for (int i=0; i<N-1; i++) integral[i] = (double) (graphs.get(i) + graphs.get(i+1)) / 2;

        answer = new double[ranges.length];

        for (int i=0; i<ranges.length; i++) {
            int a, b;
            a = ranges[i][0];
            b = N + ranges[i][1] - 1;
            if (a > b) answer[i] = -1;
            else {
                double sum = 0;
                for (int j=a; j<b; j++) sum += integral[j];
                answer[i] = sum;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][] {{0, 0}, {}}));
    }
}
