
import java.io.*;

public class Day357BOJ1890점프DP {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][N + 1];
        long[][] dp = new long[N + 1][N + 1];
        String str[];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);

            }
        }
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1)
                    continue;
                int next = arr[i][j];
                if (i + next < N) {
                    dp[i + next][j] += dp[i][j];
                }
                if (j + next < N) {
                    dp[i][j + next] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);
        br.close();
    }
}
