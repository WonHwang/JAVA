package FirstPackage;

public class P147355 {
    public static int solution(String t, String p) {
        int answer = 0;
        int N = p.length();
        long P = Long.parseLong(p);
        for (int i=0; i<t.length()-N+1; i++) {
            String tmp = t.substring(i, i+N);
            if (Long.parseLong(tmp) <= P) answer += 1;
        }
        return answer;
    }
}
