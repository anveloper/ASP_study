import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day353BOJ12865평범한배낭 {
    static int N, K;
    static int[][] list;
    static Integer[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new int[N + 1][2];
        dp = new Integer[N + 1][K + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(recur(N, K));
        br.close();
    }

    private static int recur(int i, int k) {
        if (i < 1)
            return dp[i][k] = 0;
        if (dp[i][k] == null)
            if (list[i][0] > k)
                dp[i][k] = recur(i - 1, k);
            else
                dp[i][k] = Math.max(
                        recur(i - 1, k),
                        recur(i - 1, k - list[i][0]) + list[i][1]);
        return dp[i][k];
    }
}
