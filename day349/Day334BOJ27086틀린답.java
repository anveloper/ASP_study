package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day334BOJ27086틀린답 { // 시간초과
    static final int MOD = 998_244_353;
    static int N, x, y;
    static int ans = 0, sum = 0;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                int dif = arr[j] - arr[i]; // 점수 차
                int k = Math.abs(dif / x) + 1; // 벌금 배수
                int p = k * y; // 벌금
                if (dif == 0)
                    continue;
                if (j == 0 && dif < 0)
                    ans = (ans + p) % MOD;
                sum = (sum + p) % MOD;
            }
        }
        System.out.println(sum + " " + ans);
        br.close();
    }
}