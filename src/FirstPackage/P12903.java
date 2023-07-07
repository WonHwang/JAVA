package FirstPackage;

public class P12903 {
    public static String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 1) {
            int idx = s.length() / 2;
            answer += Character.toString(s.charAt(idx));
        }
        else {
            int idx = (s.length() / 2) - 1;
            answer += Character.toString(s.charAt(idx));
            answer += Character.toString(s.charAt(idx+1));
        }
        return answer;
    }
}
