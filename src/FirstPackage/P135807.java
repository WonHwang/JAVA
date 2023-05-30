package FirstPackage;

import java.util.ArrayList;

public class P135807 {

    public static int getGcd(int a, int b) {
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }

    public static int[] getDividers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=1; i<((int) Math.sqrt(n))+1; i++) {
            if (n%i == 0) {
                result.add(i);
                result.add((int) n/i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static int getResult(int n, int[] array) {
        boolean flag = true;
        for (int i=0; i<array.length; i++) {
            int num = array[i];
            if (num >= n && num % n == 0) {
                flag = false;
                break;
            }
        }

        if (flag) return n;
        return -1;
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int gcdA, gcdB;

        gcdA = arrayA[0];
        gcdB = arrayB[0];
        for (int i=0; i<arrayA.length; i++) {
            gcdA = getGcd(gcdA, arrayA[i]);
            gcdB = getGcd(gcdB, arrayB[i]);
        }

        int[] dividersA, dividersB;
        dividersA = getDividers(gcdA);
        dividersB = getDividers(gcdB);

        int answer = 0;

        for (int i=0; i<dividersA.length; i++) {
            int result = getResult(dividersA[i], arrayB);

            if (result != -1 && (answer == 0 || result > answer)) answer = result;
        }

        for (int i=0; i<dividersB.length; i++) {
            int result = getResult(dividersB[i], arrayA);

            if (result != -1 && (answer == 0 || result > answer)) answer = result;
        }

        return answer;
    }
}
