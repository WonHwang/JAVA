package FirstPackage;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Arrays;

public class P42579 {

    public static int[] solution(String[] genres, int[] plays) {
        LinkedList<Integer> answer = new LinkedList<>();
        HashMap<String, LinkedList<int[]>> musics = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int count = plays[i];

            if (musics.get(genre) == null) musics.put(genre, new LinkedList<int[]>());
            musics.get(genre).add(new int[] {count, i});
        }

        for (String key : musics.keySet()) {
            musics.get(key).sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }
                    return o2[0] - o1[0];
                }
            });
        }

    }
}
