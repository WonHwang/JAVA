package FirstPackage;

import java.util.HashSet;
import java.util.Arrays;

public class P42839 {

    public static HashSet<Integer> answer = new HashSet<>();

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i=3; i<(int) Math.sqrt(n)+1; i+=2) {
            if (n%i == 0) return false;
        }

        return true;
    }

    public static void dfs(String numbers, int[] visited, String result) {

        if (result.length() > numbers.length()) return;
        if (result.length() >= 1 && isPrime(Integer.parseInt(result))) {
            answer.add(Integer.parseInt(result));
        }

        for (int i=0; i<numbers.length(); i++) {
            if (visited[i] == 0 && !(result == "" && numbers.charAt(i) == '0')) {
                visited[i] = 1;
                dfs(numbers, visited, result + Character.toString(numbers.charAt(i)));
                visited[i] = 0;
            }
        }
    }

    public static int solution(String numbers) {
        int[] visited = new int[numbers.length()];
        dfs(numbers, visited, "");
        return answer.size();
    }

    public static void main(String[] args) {
        System.out.println(solution("71"));
    }
}
