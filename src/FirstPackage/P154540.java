package FirstPackage;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
public class P154540 {

    public static int[] dx = new int[] {1, -1, 0, 0};
    public static int[] dy = new int[] {0, 0, 1, -1};
    public static void bfs(String[] maps, int[] start, int[][] visited, int N, int M, int step) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start[0]][start[1]] = step;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i=0; i<4; i++) {
                int x, y;
                x = node[0] + dx[i];
                y = node[1] + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < M && visited[x][y] == 0 && maps[x].charAt(y) != 'X') {
                    visited[x][y] = step;
                    queue.add(new int[] {x, y});
                }
            }
        }
    }

    public static int[] solution(String[] maps) {

        int N, M;
        N = maps.length;
        M = maps[0].length();

        int[][] visited = new int[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) visited[i][j] = 0;
        }

        int step = 1;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (visited[i][j] == 0 && maps[i].charAt(j) != 'X') {
                    bfs(maps, new int[] {i, j}, visited, N, M, step++);
                }
            }
        }
        int[] answer = new int[step-1];
        for (int i=0; i<step-1; i++) answer[i] = 0;

        for (int i=0; i<N; i++) System.out.println(Arrays.toString(visited[i]));

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (visited[i][j] != 0) {
                    answer[visited[i][j]-1] += (int) maps[i].charAt(j) - '0';
                }
            }
        }

        Arrays.sort(answer);

        if (step == 1) answer = new int[] {-1};

        return answer;
    }
}
