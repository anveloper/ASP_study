package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day322BOJ18290NMK {
    static int N, M, K, ans;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = Integer.MIN_VALUE;
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, 0, 0, 0);
        System.out.println(ans);
        br.close();
    }

    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

    private static void recur(int k, int idx, int jdx, int sum) {
        if (k == K) {
            ans = ans > sum ? ans : sum;
            return;
        }

        boolean check = false;
        for (int i = idx; i < N; i++) {
            int tmp = idx == i ? jdx : 0;
            for (int j = tmp; j < M; j++) {
                if (visited[i][j])
                    continue;
                check = true;
                for (int dir = 0; dir < 4; dir++) {
                    int nr = i + dr[dir];
                    int nc = j + dc[dir];
                    if (!index(nr, nc) && visited[nr][nc]) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    visited[i][j] = true;
                    recur(k + 1, i, j, sum + map[i][j]);
                    visited[i][j] = false;
                }
            }
        }

    }

    static boolean index(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }

}
