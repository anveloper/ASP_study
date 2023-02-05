import java.io.*;
import java.util.*;

public class Day364BOJ15681트리와쿼리 {
    static int N, R, Q;
    static Integer[] dp;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()) - 1;
        Q = Integer.parseInt(st.nextToken());

        dp = new Integer[N];
        list = new ArrayList[N];
        for (int i = 0; i < N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            list[u].add(v);
            list[v].add(u);
        }

        recur(R, -1);

        for (int i = 0; i < Q; i++)
            sb.append(dp[Integer.parseInt(br.readLine()) - 1]).append("\n");

        System.out.println(sb);
        br.close();
    }

    private static int recur(int n, int p) {
        if (dp[n] == null) {
            dp[n] = 1;
            for (int i : list[n])
                if (p != i)
                    dp[n] += recur(i, n);
        }
        return dp[n];
    }
}
