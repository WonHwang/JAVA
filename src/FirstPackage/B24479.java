package FirstPackage;

import java.io.*;
import java.util.Collections;
import java.util.ArrayList;

public class B24479 {

    public static int step = 0;

    public static void dfs(int node, ArrayList<Integer>[] grid, int[] visited) {

        visited[node] = step;
        step += 1;

        for (int i=0; i<grid[node].size(); i++) {
            int next = grid[node].get(i);
            if (visited[next] == 0) dfs(next, grid, visited);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        ArrayList<Integer>[] grid = new ArrayList[N+1];
        for (int i=0; i<N+1; i++) grid[i] = new ArrayList<>();
        for (int i=0; i<M; i++) {
            input = in.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            grid[a].add(b);
            grid[b].add(a);
        }
        in.close();

        for (int i=0; i<N+1; i++) {
            Collections.sort(grid[i]);
        }

        int[] visited = new int[N+1];

        step += 1;
        dfs(R, grid, visited);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=1; i<N+1; i++) bw.write(visited[i] + "\n");
        bw.flush();
        bw.close();
    }
}
