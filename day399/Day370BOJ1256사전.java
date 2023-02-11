
import java.io.*;
import java.util.*;

public class Day370BOJ1256사전 {
    static int N, M;
    static double K;
    static double[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new double[N + 1][M + 1];
        recur(N, M, K);

        if (check(N, M) < K)
            System.out.println(-1);
        else
            System.out.println(sb.toString());
        br.close();
    }

    private static double check(int a, int z) {
        if (a == 0 || z == 0)
            return 1;
        if (dp[a][z] != 0)
            return dp[a][z];
        return dp[a][z] = Double.min(check(a - 1, z) + check(a, z - 1), 1000000001);
    }

    private static void recur(int a, int z, double k) {
        if (a == 0) {
            for (int i = 0; i < z; i++)
                sb.append("z");
            return;
        }
        if (z == 0) {
            for (int i = 0; i < a; i++)
                sb.append("a");
            return;
        }

        double check = check(a - 1, z);

        if (k > check) {
            sb.append("z");
            recur(a, z - 1, k - check);
        } else {
            sb.append("a");
            recur(a - 1, z, k);
        }
    }
}
