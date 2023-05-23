package FirstPackage;

import java.util.HashMap;
public class P84512 {
    public static String[] wordList = new String[] {"A", "E", "I", "O", "U"};
    public static HashMap<String, Integer> map = new HashMap<>();
    public static int cnt = 0;

    public static void bfs(String word) {

        if (word.length() == 6) return;

        map.put(word, cnt);
        cnt += 1;

        for (int i=0; i<5; i++) bfs(word+wordList[i]);
    }

    public static int solution(String word) {
        int answer = 0;
        bfs("");
        return map.get(word);
    }
}
