package day349;

import java.io.*;
import java.util.*;

public class Day345BOJ2015수들의합4 {
    static int N, K;
    static int data[];
    static Map<Integer, Long> map = new HashMap<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[N + 1];

        long ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(st.nextToken()) + data[i - 1];
            if (data[i] == K) {
                ans++;
            }
            if (map.containsKey(data[i] - K))
                ans += map.get(data[i] - K);
            if (!map.containsKey(data[i]))
                map.put(data[i], 1L);
            else
                map.put(data[i], map.get(data[i]) + 1);
        }

        System.out.println(ans);
    }
}