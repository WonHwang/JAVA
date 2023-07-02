package FirstPackage;

import java.util.Arrays;

public class P12910 {

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int cnt = 0;
        for (int i=0; i<arr.length; i++) if (arr[i]%divisor == 0) cnt += 1;
        if (cnt == 0) return new int[] {-1};
        answer = new int[cnt];
        int idx = 0;
        for (int i=0; i<arr.length; i++) if (arr[i]%divisor == 0) answer[idx++] = arr[i];
        Arrays.sort(answer);
        return answer;
    }
}
