package FirstPackage;

import java.util.LinkedHashMap;
import java.util.LinkedList;
public class P155652 {

    public static String Solution(String s, String skip, int index) {
        String answer = "";

        LinkedList<Character> alphabet = new LinkedList<>();
        for (int i=0; i<26; i++) {
            int idx = i + 'a';
            boolean flag = true;
            for (int j=0; j<skip.length(); j++) {
                if ((int) skip.charAt(j) == idx) {
                    flag = false;
                    break;
                }
            }
            if (flag) alphabet.add((char) idx);
        }

        LinkedHashMap<Character, Integer> dict = new LinkedHashMap<>();
        LinkedHashMap<Integer, Character> dict2 = new LinkedHashMap<>();
        int N = alphabet.size();

        for (int i=0; i<N; i++) {
            dict.put(alphabet.get(i), i);
            dict2.put(i, alphabet.get(i));
        }

        for (int i=0; i<s.length(); i++) {
            int idx = dict.get(s.charAt(i));
            int tmp = (idx + index) % N;
            answer += dict2.get(tmp);
        }

        return answer;
    }
}
