package FirstPackage;

import java.util.Map;
import java.util.HashMap;
public class Programmers176963 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        answer = new int[photo.length];
        for (int i=0; i<photo.length; i++) {
            int sum = 0;
            for (int j=0; j<photo[i].length; j++) {
                if (map.get(photo[i][j]) != null) {
                    sum += map.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }

        return answer;
    }

}

