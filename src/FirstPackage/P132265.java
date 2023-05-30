package FirstPackage;

public class P132265 {

    public static int solution(int[] topping) {
        int answer = 0;
        int N = topping.length;
        int[] forward = new int[N];
        int[] backward = new int[N];
        int[] visitedF = new int[10001];
        int[] visitedB = new int[10001];

        for (int i=0; i<N; i++) {
            forward[i] = 0;
            backward[i] = 0;
        }

        for (int i=0; i<10001; i++) {
            visitedF[i] = 0;
            visitedB[i] = 0;
        }

        visitedF[topping[0]] = 1;
        forward[0] = 1;
        visitedB[topping[N-1]] = 1;
        backward[N-1] = 1;

        for (int i=1; i<N; i++) {
            forward[i] = forward[i-1];
            backward[N-i-1] = backward[N-i];

            if (visitedF[topping[i]] == 0) {
                visitedF[topping[i]] = 1;
                forward[i] += 1;
            }

            if (visitedB[topping[N-i-1]] == 0) {
                visitedB[topping[N-i-1]] = 1;
                backward[N-i-1] += 1;
            }
        }

        for (int i=0; i<N-1; i++) if (forward[i] == backward[i+1]) answer += 1;

        return answer;
    }
}
