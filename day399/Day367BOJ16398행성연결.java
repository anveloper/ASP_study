import java.io.*;
import java.util.*;

public class Day367BOJ16398행성연결 {
    static int N;
    static long ans = 0; // 63% 부터 long..
    static int[] p;
    static int[][] map;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        p = new int[N];
        map = new int[N][N];
        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < N; i++) {
            p[i] = i;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i < j)
                    pq.add(new int[] { i, j, map[i][j] });
            }
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int v = cur[1];
            int cost = cur[2];
            if (union(u, v))
                ans += cost;
        }

        System.out.println(ans);
        br.close();
    }

    private static boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v)
            return false;
        p[v] = u;
        return true;
    }

    private static int find(int n) {
        return p[n] = n == p[n] ? n : find(p[n]);
    }
}
