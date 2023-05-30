package FirstPackage;

public class P148653 {
    public static int solution(int storey) {
        int answer = 0;
        while (storey != 0) {
            int rest = storey % 10;
            storey /= 10;

            if (rest >= 6) {
                rest = 10 - rest;
                storey += 1;
            }
            else if (rest == 5) {
                if (storey % 10 >= 5) storey += 1;
            }

            answer += rest;
        }
        return answer;
    }
}
