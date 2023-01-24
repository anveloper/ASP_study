package day399;

import java.io.*;
import java.util.*;

public class Day352BOJ2467용액 {
    static int N, s, e, ans = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        s = 0;
        e = N - 1;
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int i = 0, j = N - 1;
        while (s < e) {
            int tmp = arr[s] + arr[e];
            if (Math.abs(ans) > Math.abs(tmp)) {
                ans = tmp;
                i = s;
                j = e;
            }

            if (tmp == 0)
                break;
            else if (tmp < 0)
                s++;
            else if (tmp > 0)
                e--;
        }
        System.out.println(arr[i] + " " + arr[j]);
        br.close();
    }
}
