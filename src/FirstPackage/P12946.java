package FirstPackage;

import java.util.LinkedList;

public class P12946 {

    public static LinkedList<int[]> hanoi(int n) {
        if (n == 1) {
            LinkedList<int[]> result = new LinkedList<>();
            result.add(new int[] {1, 3});
            return result;
        }

        LinkedList<int[]> tmp1 = hanoi(n-1);
        LinkedList<int[]> tmp2 = hanoi(n-1);
        LinkedList<int[]> result = new LinkedList<>();

        for (int i=0; i<tmp1.size(); i++) {
            int[] tmp = tmp1.get(i);
            for (int j=0; j<2; j++) {
                if (tmp[j] == 2) tmp[j] = 3;
                else if (tmp[j] == 3) tmp[j] = 2;
            }
            result.add(tmp);
        }

        result.add(new int[] {1, 3});

        for (int i=0; i<tmp2.size(); i++) {
            int[] tmp = tmp2.get(i);
            for (int j=0; j<2; j++) {
                if (tmp[j] == 1) tmp[j] = 2;
                else if (tmp[j] == 2) tmp[j] = 1;
            }
            result.add(tmp);
        }

        return result;
    }

    public static int[][] solution(int n) {
        LinkedList<int[]> result = hanoi(n);
        int[][] answer = new int[result.size()][];
        for (int i=0; i<result.size(); i++) answer[i] = result.get(i);

        return answer;
    }
}
