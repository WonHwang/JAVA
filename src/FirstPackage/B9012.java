package FirstPackage;

import java.util.Scanner;
import java.util.Stack;

public class B9012 {
    public static void main(String[] args) {
        B_9012();
    }

    public static void B_9012() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            String string = sc.next();
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            for (int i=0; i<string.length(); i++) {
                char target = string.charAt(i);
                if (target == '(') {
                    stack.push(target);
                }
                else if (target == ')') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) flag = false;
            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
