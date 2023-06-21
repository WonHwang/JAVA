package FirstPackage;

import java.util.ArrayDeque;
public class P86971 {

    public int bfs(int start, int[][] connection, int n) {

        int[] visited = new int[n];
        visited[start] = 1;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i=0; i<n; i++) {
                if (connection[node][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }

        int result = 0;
        for (int i=0; i<n; i++) result += visited[i];

        return result;
    }

    public int solution(int n, int[][] wires) {
        int answer = n+1;
        int[][] connection = new int[n][n];

        for (int i=0; i<wires.length; i++) {
            int a, b;
            a = wires[i][0]-1;
            b = wires[i][1]-1;
            connection[a][b] = 1;
            connection[b][a] = 1;
        }

        for (int i=0; i<wires.length; i++) {
            int a, b;
            a = wires[i][0]-1;
            b = wires[i][1]-1;
            connection[a][b] = 0;
            connection[b][a] = 0;
            int Min = Math.abs(bfs(a, connection, n) - bfs(b, connection, n));
            if (Min < answer) answer = Min;
            connection[a][b] = 1;
            connection[b][a] = 1;
        }
        return answer;
    }
}
