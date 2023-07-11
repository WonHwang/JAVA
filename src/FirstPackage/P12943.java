package FirstPackage;

public class P12943 {

    public static int solution(int num) {

        int answer = 0;
        long n = (long) num;
        while (n != 1) {

            if (answer == 500) break;

            answer += 1;

            if (n % 2 == 0) n /= 2;

            else {
                n *= 3;
                n += 1;
            }
        }

        if (answer == 500) answer = -1;

        return answer;
    }

}
