package FirstPackage;

import java.sql.Array;
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.lang.Integer;

public class B2178 {

    public static void solution()  {

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Scanner sc = new Scanner(System.in);
        int N, M;
        String input = sc.nextLine();
        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);

        char[][] grid = new char[101][101];
        int[][] visited = new int[101][101];

        for (int i=0; i<N; i++) {
            String line = sc.nextLine();
            for (int j=0; j<M; j++) {
                grid[i][j] = line.charAt(j);
                visited[i][j] = 0;
            }
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.clear();
        queue.addFirst(new int[] {0, 0, 1});
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];
                int step = node[2];

                if (x >= 0 && x < N && y >= 0 && y < M && visited[x][y] == 0 && grid[x][y] == '1') {
                    visited[x][y] = step + 1;
                    queue.addLast(new int[]{x, y, step + 1});
                }
            }
        }
        System.out.println(visited[N-1][M-1]);
    }

    public static void main(String[] args) {
        solution();
    }
}
