package FirstPackage;

public class P92344 {

    public static int solution(int[][] board, int[][] skill) {

        int answer = 0;
        int N, M;
        N = board.length;
        M = board[0].length;
        int[][] acc = new int[N+1][M+1];
        int[] types = {0, -1, 1};
        for (int[] sk : skill) {
            int degree = types[sk[0]] * sk[5];
            int r1, r2, c1, c2;
            r1 = sk[1];
            c1 = sk[2];
            r2 = sk[3];
            c2 = sk[4];

            acc[r1][c1] += degree;
            acc[r1][c2+1] -= degree;
            acc[r2+1][c1] -= degree;
            acc[r2+1][c2+1] += degree;
        }

        for (int i=0; i<N; i++) {
            for (int j=1; j<M; j++) acc[i][j] += acc[i][j-1];
        }

        for (int j=0; j<M; j++) {
            for (int i=1; i<N; i++) acc[i][j] += acc[i-1][j];
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                board[i][j] += acc[i][j];
                if (board[i][j] > 0) answer += 1;
            }
        }

        return answer;
    }
}
