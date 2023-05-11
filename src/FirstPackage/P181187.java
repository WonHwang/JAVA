package FirstPackage;

public class P181187 {

    public static long solution(int r1, int r2) {

        long answer = 0;

        int julpyun = 0;
        for (int i=r1; i<=r2; i++) julpyun += 1;

        for (int i=0; i<=r2; i++) {
            for (int j=0; j<i; j++) {
                int tmp = i*i + j*j;
                if (tmp >= r1*r1 && tmp <= r2*r2) answer += 1;
            }
        }

        answer -= julpyun;
        answer *= 2;
        answer += julpyun;

        for (int i=0; i<=r2; i++) {
            if (2*i*i >= r1*r1 && 2*i*i <= r2*r2) answer += 1;
        }

        answer *= 4;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2,3));
    }
}
