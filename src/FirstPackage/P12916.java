package FirstPackage;

public class P12916 {

    public static boolean solution(String s) {
        boolean answer = true;

        int p, y;
        p = 0;
        y = 0;

        for (int i=0; i<s.length(); i++) {
            char tmp = s.charAt(i);

            if (tmp == 'p' || tmp == 'P') p += 1;
            else if (tmp == 'y' || tmp == 'Y') y += 1;
        }

        if (p != y) answer = false;
        return answer;
    }
}
