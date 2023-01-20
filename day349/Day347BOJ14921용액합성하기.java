package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day347BOJ14921용액합성하기 {
    static int N, s, e, ans = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        s = 0;
        e = N - 1;
        while (s < e) {
            int tmp = arr[s] + arr[e];
            ans = Math.abs(tmp) < Math.abs(ans) ? tmp : ans;

            if (tmp == 0)
                break;
            else if (tmp < 0)
                s++;
            else if (tmp > 0)
                e--;
        }

        System.out.println(ans);
        br.close();
    }
}
