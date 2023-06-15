package FirstPackage;

import java.util.LinkedHashMap;

public class P49994 {

    public static int solution(String dirs) {

        int answer = 0;
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};
        LinkedHashMap<Character, Integer> direction = new LinkedHashMap<>();
        direction.put('U', 0);
        direction.put('D', 1);
        direction.put('R', 2);
        direction.put('L', 3);

        int x, y;
        x = 0;
        y = 0;
        LinkedHashMap<String, int[]> visited = new LinkedHashMap<>();
        visited.put(Integer.toString(x) + " " + Integer.toString(y), new int[4]);

        for (int j=0; j<dirs.length(); j++) {
            int i = direction.get(dirs.charAt(j));
            String key = Integer.toString(x) + " " + Integer.toString(y);
            int a = x + dx[i], b = y + dy[i];

            if (Math.abs(a) > 5 || Math.abs(b) > 5) continue;

            if (visited.get(key)[i] == 0) {
                visited.get(key)[i] = 1;
                answer += 1;
            }

            String newKey = Integer.toString(a) + " " + Integer.toString(b);
            if (visited.get(newKey) == null) {
                visited.put(newKey, new int[4]);
            }

            if (i%2 == 1) {
                visited.get(newKey)[i-1] = 1;
            }
            else {
                visited.get(newKey)[i + 1] = 1;
            }
            x = a;
            y = b;
        }
        return answer;
    }
}
