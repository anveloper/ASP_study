package day399;

import java.io.*;
import java.util.*;

public class Day376BOJ1719택배 { //
    static int N, M;
    static Integer[][] map, p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Integer[N + 1][N + 1];
        p = new Integer[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++)
            Arrays.fill(map[i], 1 << 20);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[u][v] = map[v][u] = Math.min(map[u][v], c);
            p[u][v] = v;
            p[v][u] = u;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        p[i][j] = p[i][k];
                    }
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i == j)
                    sb.append("- ");
                else
                    sb.append(p[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
