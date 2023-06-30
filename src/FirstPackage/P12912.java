package FirstPackage;

public class P12912 {

    public static long solution(int a, int b) {

        long answer = 0;
        if (a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        for (int i=a; i<=b; i++) answer += (long) i;
        return answer;g
    }
}
