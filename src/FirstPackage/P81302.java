package FirstPackage;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class P81302 {

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static boolean bfs(int[] start, int[] end, String[] place) {

        int[][] visited = new int[5][5];
        visited[start[0]][start[1]] = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int a, b, step;
            a = node[0];
            b = node[1];
            step = visited[a][b];

            if (a == end[0] && b == end[1]) {
                if (step > 3) return true;
                return false;
            }

            for (int i=0; i<4; i++) {
                int x, y;
                x = a + dx[i];
                y = b + dy[i];

                if (x >= 0 && x < 5 && y >= 0 && y < 5 && visited[x][y] == 0 && place[x].charAt(y) != 'X') {
                    visited[x][y] = step + 1;
                    queue.add(new int[] {x, y});
                }
            }
        }

        return true;
    }

    public static int getAnswer(String[] place) {
        ArrayList<int[]> points = new ArrayList<>();

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (place[i].charAt(j) == 'P') {
                    points.add(new int[] {i, j});
                }
            }
        }

        for (int i=0; i<points.size()-1; i++) {
            for (int j=i+1; j<points.size(); j++) {
                int[] start = points.get(i);
                int[] end = points.get(j);

                if (!bfs(start, end, place)) return 0;
            }
        }

        return 1;
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i=0; i<5; i++) {
            String[] place = places[i];
            answer[i] = getAnswer(place);
        }

        return answer;
    }
}
