package FirstPackage;

import java.util.ArrayDeque;

public class P1844 {

    public static int solution(int[][] maps) {

        int answer = -1;
        int N, M;

        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        N = maps.length;
        M = maps[0].length;
        int[][] visited = new int[N][M];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int a, b, step;
            a = node[0];
            b = node[1];
            step = visited[a][b];

            for (int i=0; i<4; i++) {
                int x, y;
                x = a + dx[i];
                y = b + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < M && visited[x][y] == 0 && maps[x][y] == 1) {
                    visited[x][y] = step+1;
                    queue.add(new int[] {x, y});
                }
            }
        }

        if (visited[N-1][M-1] != 0) answer = visited[N-1][M-1];

        return answer;
    }
}
