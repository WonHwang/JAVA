package FirstPackage;

public class P121684 {

    public static int Max = 0;

    public static void dfs(int[][] ability, int[] visited, int people, int depth, int step, int score) {

        if (step == depth) {
            if (score > Max) Max = score;
            return;
        }

        for (int i=0; i<people; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                dfs(ability, visited, people, depth, step+1, score + ability[i][step]);
                visited[i] = 0;
            }
        }
    }
    public static int solution(int[][] ability) {
        int people, depth;
        people = ability.length;
        depth = ability[0].length;
        int[] visited = new int[people];
        dfs(ability, visited, people, depth, 0, 0);
        int answer = Max;
        return answer;
    }
}
