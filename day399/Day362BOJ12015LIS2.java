package day399;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day362BOJ12015LIS2 {
    static int N, num, idx = 0;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        dp = new int[N];
        dp[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            if (num > dp[idx])
                dp[++idx] = num;
            else
                dp[find(0, idx)] = num;
        }
        System.out.println(idx + 1);
        br.close();
    }

    private static int find(int st, int ed) {
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (dp[mid] == num)
                return mid;
            if (dp[mid] < num)
                st = mid + 1;
            else
                ed = mid - 1;
        }
        return st;
    }
}
