package FirstPackage;

import java.util.Stack;

public class P12973 {

    public static int solution2(String s) {
        long beforeTime = System.currentTimeMillis();
        int answer = 0;
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek().equals(s.split("")[i])) {
                stack.pop();
            }else {
                stack.push(s.split("")[i]);
            }
        }
        answer = stack.isEmpty() ? 1 : 0;

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("시간차이(m) : "+secDiffTime);
        return answer;
    }

    public static int solution(String s) {
        long beforeTime = System.currentTimeMillis();
        int answer = 0;
        Stack<String> stack = new Stack<>();
        String[] split = s.split("");

        for (int i = 0; i < split.length; i++) {
            if (!stack.isEmpty() && stack.peek().equals(split[i])) {
                stack.pop();
            } else {
                stack.push(split[i]);
            }
        }
        answer = stack.isEmpty() ? 1 : 0;

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("시간차이(m) : "+secDiffTime);
        return answer;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaa";
        System.out.println(s.length());
        System.out.println(solution(s));
        System.out.println(solution2(s));
    }
}
