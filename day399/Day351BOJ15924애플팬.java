package day399;

import java.io.*;
import java.util.*;

public class Day351BOJ15924애플팬 {
    private static final int MOD = 1_000_000_009;

    private static final char EAST = 'E';
    private static final char SOUTH = 'S';
    private static final char BOTH = 'B';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        System.out.println(path(N, M, map));
    }

    private static long path(int n, int m, char[][] arr) {
        long[][] dp = new long[n][m];
        dp[n - 1][m - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            if (arr[n - 1][i] == EAST || arr[n - 1][i] == BOTH)
                dp[n - 1][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i][m - 1] == SOUTH || arr[i][m - 1] == BOTH)
                dp[i][m - 1] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                long sum = (arr[i][j] == EAST || arr[i][j] == BOTH ? dp[i][j + 1] : 0) +
                        (arr[i][j] == SOUTH || arr[i][j] == BOTH ? dp[i + 1][j] : 0);

                dp[i][j] = ((dp[i][j] % MOD) + sum) % MOD;
            }
        }

        long total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                total = ((total % MOD) + (dp[i][j] % MOD) % MOD);
            }
        }

        return total;
    }
}
