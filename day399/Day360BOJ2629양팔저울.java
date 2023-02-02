
import java.io.*;
import java.util.*;

public class Day360BOJ2629양팔저울 {
    static int N, M, question, max = 15000, arr[];
    static boolean dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new boolean[31][max + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recur(0, 0);

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            question = Integer.parseInt(st.nextToken());
            if (question > 15000)
                sb.append("N ");
            else
                sb.append(dp[N][question] ? "Y " : "N ");
        }
        System.out.println(sb);
        br.close();
    }

    public static void recur(int idx, int weight) {
        if (dp[idx][weight])
            return;
        dp[idx][weight] = true;
        if (idx == N)
            return;

        recur(idx + 1, weight + arr[idx + 1]);
        recur(idx + 1, weight);
        recur(idx + 1, Math.abs(weight - arr[idx + 1]));
    }
}
