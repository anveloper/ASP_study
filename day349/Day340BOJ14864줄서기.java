package day349;

import java.io.*;
import java.util.*;

public class Day340BOJ14864줄서기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        boolean[] sw = new boolean[N + 1];
        int[] arr = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())]++;
            arr[Integer.parseInt(st.nextToken())]--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            arr[i] += i;

            if (sw[arr[i]]) {
                System.out.print(-1);
                return;
            }
            sw[arr[i]] = true;
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
