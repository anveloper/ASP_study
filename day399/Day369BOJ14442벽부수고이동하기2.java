import java.io.*;
import java.util.*;

public class Day369BOJ14442벽부수고이동하기2 {
    static int N, M, K;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static int[][] map;
    static Queue<int[]> q;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = str.charAt(j) - '0';
        }

        System.out.println(bfs());
        br.close();
    }

    private static int bfs() {
        q = new LinkedList<>();
        visited = new boolean[N][M][K + 1];

        visited[0][0][0] = true;
        q.add(new int[] { 0, 0, 0, 1 });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], k = cur[2], d = cur[3];

            if (r == N - 1 && c == M - 1)
                return d;

            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (index(nr, nc))
                    continue;

                if (map[nr][nc] == 0 && !visited[nr][nc][k]) {
                    visited[nr][nc][k] = true;
                    q.add(new int[] { nr, nc, k, d + 1 });
                } else if (k < K && !visited[nr][nc][k + 1]) {
                    visited[nr][nc][k + 1] = true;
                    q.add(new int[] { nr, nc, k + 1, d + 1 });
                }
            }
        }
        return -1;
    }

    private static boolean index(int nr, int nc) {
        return nr < 0 || nr >= N || nc < 0 || nc >= M;
    }
}
