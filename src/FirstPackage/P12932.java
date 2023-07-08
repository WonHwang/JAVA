package FirstPackage;

public class P12932 {

    public static int[] solution(long n) {
        int[] answer = {};
        int N  = 0;
        long tmp = n;
        N = Long.toString(tmp).length();
        answer = new int[N];
        for (int i=0; i<N; i++) {
            long rest = n%10;
            answer[i] = (int) rest;
            n /= 10;
        }
        return answer;
    }
}
