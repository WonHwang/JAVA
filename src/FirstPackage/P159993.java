package FirstPackage;

import java.util.*;
public class P159993 {

    public int[] dx = new int[] {1, -1, 0, 0};
    public int[] dy = new int[] {0, 0, 1, -1};

    public int bfs(String[] maps, int[] start, int[] end) {
        int N, M;
        N = maps.length;
        M = maps[0].length();
        int[][] visited = new int[100][100];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) visited[i][j] = 0;
        }
        visited[start[0]][start[1]] = 1;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int step = visited[node[0]][node[1]];

            for (int i=0; i<4; i++) {
                int x, y;
                x = node[0] + dx[i];
                y = node[1] + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < M && visited[x][y] == 0 && maps[x].charAt(y) != 'X') {
                    visited[x][y] = step + 1;
                    queue.add(new int[] {x, y});
                }
            }
        }

        return visited[end[0]][end[1]] - 1;
    }

    public int[] findGrid (String[] maps, char target) {
        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps[0].length(); j++) {
                if (maps[i].charAt(j) == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
    public int solution (String[] maps) {
        int[] start, lock, end;
        start = findGrid(maps, 'S');
        lock = findGrid(maps, 'L');
        end = findGrid(maps, 'E');

        int first = bfs(maps, start, lock);
        if (first == -1) return -1;

        int second = bfs(maps, lock, end);
        if (second == -1) return -1;

        return first + second;
    }
}
