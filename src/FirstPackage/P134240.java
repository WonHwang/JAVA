package FirstPackage;

public class P134240 {

    public static String Solution(int[] food) {
        String answer = "";
        String reverse = "";
        for (int i=1; i<food.length; i++) {
            for (int j=0; j<food[i]/2; j++){
                answer += Integer.toString(i);
                reverse = Integer.toString(i) + reverse;
            }
        }

        answer = answer + "0" + reverse;

        return answer;
    }
}
