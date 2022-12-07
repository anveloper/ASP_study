package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day304BOJ10819차이최대 {
    static boolean[] v;
    static int[] arr;
    static int answer = 0;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        v = new boolean[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0, 0);
        System.out.println(answer);
        br.close();
    }

    static void dfs(int cnt, int bf, int sum) {
        if (cnt == n) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (v[i])
                continue;
            v[i] = true;
            dfs(cnt + 1, arr[i], cnt == 0 ? 0 : sum + Math.abs(bf - arr[i]));
            v[i] = false;
        }
    }
}
