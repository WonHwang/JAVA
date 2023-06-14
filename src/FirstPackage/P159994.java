package FirstPackage;
public class P159994 {

    public static String solution(String[] cards1, String[] cards2, String[] goals) {
        String answer = "";
        int pnt1, pnt2;
        pnt1 = 0;
        pnt2 = 0;

        for (int i=0; i<goals.length; i++) {
            if (pnt1 < cards1.length && cards1[pnt1].equals(goals[i])) {
                pnt1 += 1;
                continue;
            }

            if (pnt2 < cards2.length && cards2[pnt2].equals(goals[i])) {
                pnt2 += 1;
                continue;
            }

            answer = "No";
            break;
        }

        if (answer == "") answer = "Yes";
        return answer;
    }
}
