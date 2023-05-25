package FirstPackage;

import java.util.Arrays;
public class P147354 {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (x1, x2) -> {
            if (x1[col-1] == x2[col-1]) {
                return x2[0] - x1[0];
            }

            return x1[col-1] - x2[col-1];
        });

        for (int i=row_begin-1; i<row_end; i++) {
            int S = 0;
            for (int j=0; j<data[i].length; j++) {
                S += data[i][j] % (i+1);
            }

            answer ^= S;
        }

        return answer;
    }
}
