package FirstPackage;

public class P87389 {

    public static int solution(int n) {
        for (int i=2; i<n; i++) {
            if (n%i == 1) return i;
        }
        return 0;
    }
}
