package FirstPackage;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;

public class P131127 {

    public static boolean isOkay(LinkedHashMap<String, Integer> count) {
        for (String key : count.keySet()) {
            if (count.get(key) > 0) return false;
        }
        return true;
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> disc = new ArrayDeque<>();
        LinkedHashMap<String, Integer> count = new LinkedHashMap<>();

        for (int i=0; i<want.length; i++) count.put(want[i], number[i]);

        for (int i=0; i<discount.length; i++) disc.add(discount[i]);
        for (int i=0; i<10; i++) {
            String item = disc.poll();
            if (count.containsKey(item)) {
                count.put(item, count.get(item) - 1);
            }
            queue.add(item);
        }

        if (isOkay(count)) answer += 1;

        while (!disc.isEmpty()) {
            String item = disc.poll();
            if (count.containsKey(item)) {
                count.put(item, count.get(item) - 1);
            }
            queue.add(item);

            item = queue.poll();
            if (count.containsKey(item)){
                count.put(item, count.get(item) + 1);
            }

            if (isOkay(count)) answer += 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want, number, discount));
    }
}
