package FirstPackage;

public class P12948 {

    public static String solution(String phone_number) {
        String answer = "";
        int digit = phone_number.length()-4;
        for (int i=0; i<digit; i++) answer += "*";
        for (int i=digit; i<phone_number.length(); i++) answer += Character.toString(phone_number.charAt(i));
        return answer;
    }
}
