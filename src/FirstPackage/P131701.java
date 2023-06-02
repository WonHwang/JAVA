package FirstPackage;

import java.util.Set;
import java.util.LinkedHashSet;

public class P131701 {

    public static int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new LinkedHashSet<>();
        int N = elements.length;
        int[] element = new int[2*N];
        for (int i=0; i<2*N; i++) element[i] = elements[i%N];
        for (int i=1; i<=N; i++) {
            for (int j=0; j<N; j++) {
                int sum = 0;
                for (int k=0; k<i; k++) sum += element[j+k];
                set.add(sum);
            }
        }

        answer = set.size();
        return answer;
    }
}
