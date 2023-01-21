package day349;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day348BOJ1261알고스팟 {
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j - 1));
            }
        }

        bw.write(bfs(1, 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int idx, int jdx) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        boolean[][] visit = new boolean[N + 1][M + 1];

        pq.offer(new int[] { idx, jdx, 0 });
        visit[idx][jdx] = true;

        int nr, nc;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[0] == N && cur[1] == M) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                nr = cur[0] + dr[i];
                nc = cur[1] + dc[i];

                if (index(nr, nc))
                    continue;

                if (!visit[nr][nc] && map[nr][nc] == 0) {
                    pq.offer(new int[] { nr, nc, cur[2] });
                    visit[nr][nc] = true;
                }

                if (!visit[nr][nc] && map[nr][nc] == 1) {
                    pq.offer(new int[] { nr, nc, cur[2] + 1 });
                    visit[nr][nc] = true;
                }
            }
        }
        return 0;
    }

    private static boolean index(int nr, int nc) {
        return nr < 1 || nc < 1 || nr > N || nc > M;
    }

}
