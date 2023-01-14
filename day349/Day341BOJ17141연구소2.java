package day349;

import java.io.*;
import java.util.*;

public class Day341BOJ17141연구소2 {
    static int N, M, cnt, ans;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static int[][] map, sel;
    static List<int[]> list;
    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        ans = N * N;
        list = new ArrayList<>();
        map = new int[N][N];
        sel = new int[M][];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2)
                    list.add(new int[] { i, j });
                else if (map[i][j] == 0)
                    cnt++;
            }
        }
        comb(0, 0);
        System.out.println(ans == N * N ? -1 : ans);
        br.close();
    }

    private static void comb(int d, int idx) {
        if (d == M) {
            bfs();
            return;
        }
        if (idx == list.size())
            return;
        sel[d] = list.get(idx);
        comb(d + 1, idx + 1);
        comb(d, idx + 1);
    }

    private static void bfs() {
        boolean[][] visited = new boolean[N][N];
        int c = cnt;
        q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            q.add(new int[] { sel[i][0], sel[i][1], 0 });
            visited[sel[i][0]][sel[i][1]] = true;
        }

        int tmp = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            tmp = cur[2];
            for (int dir = 0; dir < 4; dir++) {
                int nr = cur[0] + dr[dir];
                int nc = cur[1] + dc[dir];
                if (index(nr, nc))
                    continue;
                if (visited[nr][nc])
                    continue;
                if (map[nr][nc] == 1)
                    continue;
                q.add(new int[] { nr, nc, cur[2] + 1 });
                visited[nr][nc] = true;
                if (map[nr][nc] == 0)
                    c--;
            }
        }
        if (c == 0)
            ans = Math.min(ans, tmp);
    }

    private static boolean index(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= N;
    }
}
