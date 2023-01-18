package day349;

public class Day345P43105정수삼각형DP {
    static int N, M, ans = 0;

    public static int day345P43105정수삼각형DP(int[][] dp) {
        N = dp.length;
        for (int i = 1; i < N; i++) {
            M = dp[i].length;
            for (int j = 0; j < M; j++) {
                if (j == 0)
                    dp[i][j] += dp[i - 1][j];
                else if (j == M - 1)
                    dp[i][j] += dp[i - 1][j - 1];
                else
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            if (ans < dp[N - 1][i])
                ans = dp[N - 1][i];
        }
        return ans;
    }

    public static int before(int[][] tri) {
        int N = tri.length;
        int ans = 0;
        int[][] dp = new int[N][];
        dp[0] = new int[] { tri[0][0] };
        for (int i = 1; i < N; i++) {
            dp[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (j == 0)
                    dp[i][j] = tri[i][j] + dp[i - 1][j];
                else if (j == i)
                    dp[i][j] = tri[i][j] + dp[i - 1][j - 1];
                else
                    dp[i][j] = tri[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            if (ans < dp[N - 1][i])
                ans = dp[N - 1][i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                day345P43105정수삼각형DP(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } }));
        // System.out.println(before(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7,
        // 4, 4 }, { 4, 5, 2, 6, 5 } }));
    }
}
