package day399;

import java.io.*;
import java.util.*;

public class Day350BOJ1127떡국 { // g선생님
    static int N, K, t, ans = 0, INF = (int) 1e9;
    static int[][] c, s, e;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        t = N + 1;
        c = new int[t + 1][t + 1];

        for (int i = 1; i <= N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++)
                c[i][j + 1] = tmp.charAt(j) - '0';
        }

        K = Integer.parseInt(br.readLine());
        s = new int[K][N + 1];
        e = new int[K][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            while (cnt-- > 0)
                s[Integer.parseInt(st.nextToken())][i]++;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            while (cnt-- > 0)
                e[Integer.parseInt(st.nextToken())][i]++;
        }

        for (int i = 0; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                c[0][j] = c[j][t] = 0;
                if (s[i][j] == 1)
                    c[0][j] = INF;
                if (e[i][j] == 0)
                    c[j][t] = INF;
            }
            int f[][] = new int[t + 1][t + 1];
            while (true) {
                int p[] = new int[t + 1];
                for (int j = 1; j <= t; j++)
                    p[j]--;
                Queue<Integer> q = new LinkedList<>();
                q.add(0);
                Loop: while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int next = 1; next <= t; next++) {
                        if (c[cur][next] > f[cur][next] && p[next] == -1) {
                            p[next] = cur;
                            if (next == t)
                                break Loop;
                            q.add(next);
                        }
                    }
                }
                if (p[t] == -1)
                    break;
                for (int j = t; j > 0; j = p[j]) {
                    f[p[j]][j]++;
                    f[j][p[j]]--;
                }
                ans++;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
