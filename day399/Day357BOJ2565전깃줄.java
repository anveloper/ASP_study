import java.io.*;
import java.util.*;

public class Day357BOJ2565전깃줄 {
    static int N, ans = 0;
    static int[][] line;
    static Integer[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        line = new int[N][];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        }

        Arrays.sort(line, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (line[i][1] > line[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(N - ans);
        br.close();
    }
}
