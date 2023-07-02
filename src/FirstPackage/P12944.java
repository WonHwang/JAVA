package FirstPackage;

import java.util.Arrays;
public class P12944 {

    public static double solution(int[] arr) {
        double answer = 0;
        for (int i=0; i<arr.length; i++) answer += arr[i];
        answer /= arr.length;
        return answer;
    }
}
