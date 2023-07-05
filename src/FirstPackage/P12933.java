package FirstPackage;

import java.util.Arrays;

public class P12933 {

    public static long solution(long n) {
        long answer = 0;
        int size = Long.toString(n).length();
        int[] digits = new int[size];
        for (int i=0; i<size; i++) {
            digits[i] = (int) Long.toString(n).charAt(i) - '0';
        }
        Arrays.sort(digits);
        for (int i=size-1; i>0; i--) {
            answer += digits[i];
            answer *= 10;
        }
        answer += digits[0];
        return answer;
    }
}
