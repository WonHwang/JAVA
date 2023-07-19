package FirstPackage;

public class P12919 {
    public static String solution(String[] seoul) {
        int idx = 0;
        for (int i=0; i<seoul.length; i++) {
            if ("Kim".equals(seoul[i])) {
                idx = i;
                break;
            }
        }

        String answer;
        answer = "김서방은 " + Integer.toString(idx) + "에 있다";
        return answer;
    }
}
