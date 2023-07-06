package FirstPackage;

public class P12934 {
    public static long solution(long n) {
        long answer = 0;
        long x = (long) Math.sqrt(n);
        if (x*x == n) answer = (x+1) * (x+1);
        else answer = -1;
        return answer;
    }
}
