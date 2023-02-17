package day399;

import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        for (int i = 1; i < N + 1; i++)
            p[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (cmd == 0)
                union(a, b);
            else if (cmd == 1)
                sb.append(find(a) == find(b) ? "YES\n" : "NO\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) // 사용안함
            return false;
        p[b] = a;
        return true;
    }

    private static int find(int a) {
        return p[a] = a == p[a] ? a : find(p[a]);
    }
}
