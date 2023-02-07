import java.io.*;
import java.util.*;

public class Day366BOJ11437LCA {
    static int N, M, D;
    static List<Integer>[] list;
    static Integer[] depth;
    static int[][] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = (int) (Math.ceil(Math.log(N) / Math.log(2)) + 1);

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++)
            list[i] = new ArrayList<>();

        depth = new Integer[N + 1];
        parent = new int[N + 1][D];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        dfs(1, 1, 1);

        for (int i = 1; i < D; i++)
            for (int j = 1; j < N + 1; j++)
                parent[j][i] = parent[parent[j][i - 1]][i - 1];

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(LCA(l, r)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int LCA(int l, int r) {
        if (depth[l] < depth[r]) {
            int tmp = l;
            l = r;
            r = tmp;
        }

        if (depth[l] != depth[r]) {
            int diff = depth[l] - depth[r];
            for (int i = 0; i < D; i++)
                if ((diff & (1 << i)) != 0)
                    l = parent[l][i];
        }

        if (l == r)
            return l;

        for (int i = D - 1; i >= 0; i--)
            if (parent[l][i] != parent[r][i]) {
                l = parent[l][i];
                r = parent[r][i];
            }

        return parent[l][0];

    }

    private static void dfs(int c, int p, int d) {
        if (depth[c] == null) {
            depth[c] = d;
            parent[c][0] = p;

            for (int nc : list[c])
                dfs(nc, c, d + 1);
        }
    }
}
