package FirstPackage;

import java.lang.Math;
public class P181187 {

    public static long solution(int r1, int r2) {

        long answer = 0;

        for (int x=1; x<=r2; x++) {
            int lowerBound = (int) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)));
            int upperBound = (int) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2)));

            answer += upperBound - lowerBound + 1;
        }

        return 4 * answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(2,3));

    }
}
