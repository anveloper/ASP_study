package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day334BOJ27086점수내기 { // g
    static final int MOD = 998_244_353;
    static int N, x, y;
    static long ans;
    static int[] arr, cnt, sum;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new int[N]; // 2 * 10^5
        sum = new int[N + 1];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = max > arr[i] ? max : arr[i];
        }

        cnt = new int[max + 1];
        for (int i = 0; i < N; i++) {
            ++cnt[arr[i]];
        } // 점수 분포

        sum = new int[max + 1];
        for (int i = 1; i < max + 1; i++) {
            sum[i] = sum[i - 1] + cnt[i];
        } // 점수 i를 기준으로 벌금을 내야하는 사람들의 누적합

        dp = new long[max + 1];
        for (int i = max; i > 0; i--) {
            dp[i] = i + x < max + 1 ? dp[i + x] + cnt[i + x] : 0;
            dp[i] = (dp[i] + N - sum[i]) % MOD;
            // print(dp);
        }
        // i + x 인덱스 체크 후 누적된 벌금 배수 k (x마다 증가),
        // 총원 - 점수 i보다 같거나 낮은 누적합 = 점수 i보다 높은 사람 수

        ans = 0;
        for (int i = 0; i < N; i++) {
            ans += dp[arr[i]];
        }

        System.out.println(ans % MOD * y % MOD + " " + dp[arr[0]] * y % MOD);
        br.close();
    }

    private static void print(long[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i] + " ");
        }
        System.out.println(sb);
    }
}
