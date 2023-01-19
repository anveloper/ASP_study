package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day346BOJ7490영만들기 {
    static int N, T;
    static StringBuilder ans;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            ans = new StringBuilder();
            dfs(1, 1, 0, 1, "1");
            // sb.append(ans);
            System.out.println(ans);
        }
        // System.out.println(sb);
        br.close();
    }

    private static void dfs(int d, int n, int sum, int op, String str) {
        if (d == N) {
            sum += (n * op);
            if (sum == 0)
                ans.append(str + "\n");
            return;
        }
        dfs(d + 1, n * 10 + (d + 1), sum, op, str + " " + Integer.toString(d + 1));
        dfs(d + 1, d + 1, sum + (n * op), 1, str + "+" + Integer.toString(d + 1));
        dfs(d + 1, d + 1, sum + (n * op), -1, str + "-" + Integer.toString(d + 1));
    }
}
