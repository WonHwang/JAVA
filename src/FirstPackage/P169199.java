package FirstPackage;

import java.util.*;
public class P169199 {

    public static int[] dx = new int[] {1, -1, 0, 0};
    public static int[] dy = new int[] {0, 0, 1, -1};
    public static int[] move(String[] board, int[] node, int direction) {

        int N, M, a, b;
        N = board.length;
        M = board[0].length();
        a = node[0];
        b = node[1];

        while (true) {

            int x, y;
            x = a + dx[direction];
            y = b + dy[direction];

            if (!(x >= 0 && x < N && y >= 0 && y < M && board[x].charAt(y) != 'D')) {
                return new int[] {a, b};
            }

            a = x;
            b = y;
        }
    }
    public static int solution(String[] board) {

        int answer = 0;
        int N, M;
        N = board.length;
        M = board[0].length();

        int[] start = {N, M};
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (board[i].charAt(j) == 'R') {
                    start = new int[] {i, j};
                    break;
                }
            }
            if (start[0] != N && start[1] != M) {
                break;
            }
        }

        int[] end = {N, M};
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (board[i].charAt(j) == 'G') {
                    System.out.println(i + " " + j);
                    end = new int[] {i, j};
                    break;
                }
            }
            if (end[0] != N && end[1] != M) {
                break;
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        int[][] visited = new int[100][100];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) visited[i][j] = 0;
        }
        visited[start[0]][start[1]] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int step = visited[node[0]][node[1]];

            for (int i=0; i<4; i++) {
                int[] next = move(board, node, i);
                int x, y;
                x = next[0];
                y = next[1];

                if (visited[x][y] == 0) {
                    visited[x][y] = step + 1;
                    queue.add(new int[] {x, y});
                }
            }
        }

        answer = visited[end[0]][end[1]] - 1;

        return answer;
    }

    public static void main(String[] args) {
        int answer;
        answer = solution(new String[] {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."});
        System.out.println(answer);
        answer = solution(new String[] {".D.R", "....", ".G..", "...D"});
        System.out.println(answer);
    }
}
