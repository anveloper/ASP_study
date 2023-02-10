import java.io.*;
import java.util.*;

public class Day368BOJ2665미로만들기b {
    static int N;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static int[][] map, dist;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = '1' - str.charAt(j);
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        dist[0][0] = 0;
        pq.add(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], d = cur[2];
            if (r == N - 1 && c == N - 1)
                break;
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (index(nr, nc))
                    continue;
                if (dist[nr][nc] > d + map[nr][nc])
                    pq.add(new int[] { nr, nc, dist[nr][nc] = d + map[nr][nc] });
            }
        }

        System.out.println(dist[N - 1][N - 1]);
        br.close();
    }

    private static boolean index(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= N || nc >= N;
    }
}
