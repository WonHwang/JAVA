package FirstPackage;

import java.util.HashSet;

public class P136798 {

    public static int findCnt(int n) {
        HashSet<Integer> result = new HashSet<>();

        for (int i=1; i<(int) Math.sqrt(n) + 1; i++) {
            if (n%i == 0) {
                result.add(i);
                result.add(n/i);
            }
        }

        return result.size();
    }
    public static int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i=1; i<=number; i++) {
            int result = findCnt(i);
            if (result > limit) answer += power;
            else answer += result;
        }

        return answer;
    }
}
