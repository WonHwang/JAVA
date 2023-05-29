package FirstPackage;

import java.lang.Math;
public class P140107 {

    public static long solution(int k, int d) {

        long answer = 0;

        double r = (double) d / k;

        System.out.println(r);

        for (int x=0; x<((int) r) + 1; x++) {
            int y = (int) Math.sqrt(Math.pow(r, 2) - Math.pow(x, 2));
            answer += y+1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 1000000)); // 87266796053
        System.out.println(solution(5, 1000000)); // 3141612610 6
    }

}
