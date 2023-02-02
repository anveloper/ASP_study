import java.io.*;
import java.util.*;

public class Day360BOJ2206벽부수고이동하기 {
    static int N, M;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static int[][] map;
    static int[][][] cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cnt = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++)
                map[i][j] = str.charAt(j) - '0';
        }

        System.out.println(bfs());
        br.close();
    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        cnt[0][0][0] = 1;
        q.add(new int[] { 0, 0, 0 });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], stroy = cur[2];

            if (r == N - 1 && c == M - 1)
                return cnt[r][c][stroy];

            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (index(nr, nc))
                    continue;

                if (map[nr][nc] == 0 && cnt[nr][nc][stroy] == 0) {
                    cnt[nr][nc][stroy] = cnt[r][c][stroy] + 1;
                    q.add(new int[] { nr, nc, stroy });
                }

                else if (map[nr][nc] == 1 && cnt[nr][nc][stroy] == 0 && stroy == 0) {
                    cnt[nr][nc][1] = cnt[r][c][0] + 1;
                    q.add(new int[] { nr, nc, 1 });
                }
            }
        }

        return -1;
    }

    private static boolean index(int nr, int nc) {
        return nr < 0 || nr >= N || nc < 0 || nc >= M;
    }
}
