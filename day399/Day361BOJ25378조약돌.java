import java.io.*;
import java.util.*;

public class Day361BOJ25378조약돌 {
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 2; i < N + 1; i++) {
            int tmp = dp[i - 1];
            for (int j = i - 1, k = arr[i]; j > 0; j--) {
                k = arr[j] - k;
                if (k < 0)
                    break;
                if (k == 0 && tmp <= dp[j - 1])
                    tmp = dp[j - 1] + 1;
            }
            dp[i] = tmp;
        }
        System.out.println(N - dp[N]);
        br.close();
    }
}
