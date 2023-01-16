package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day343BOJ1937욕심쟁이판다 {
    static int N, ans = 0;
    static int[] dr = { 0, 0, 1, -1 }, dc = { 1, -1, 0, 0 };
    static int[][] map, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, recur(i, j));
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static int recur(int r, int c) {
        if (dp[r][c] == 0) {
            dp[r][c] = 1;
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (index(nr, nc))
                    continue;
                if (map[r][c] < map[nr][nc])
                    dp[r][c] = Math.max(dp[r][c], recur(nr, nc) + 1);
            }
        }
        return dp[r][c];
    }

    private static boolean index(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= N || nc >= N;
    }
}
