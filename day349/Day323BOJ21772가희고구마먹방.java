package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day323BOJ21772가희고구마먹방 {
    static int R, T, C, ans = 0;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        int idx = 0, jdx = 0;
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'G') {
                    idx = i;
                    jdx = j;
                }
            }
        }
        dfs(0, idx, jdx, 0);
        System.out.println(ans);
        br.close();
    }

    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

    private static void dfs(int t, int idx, int jdx, int sum) {
        if (t == T) {
            ans = ans > sum ? ans : sum;
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            int nr = idx + dr[dir];
            int nc = jdx + dc[dir];

            if (index(nr, nc))
                continue;
            if (map[nr][nc] == '#')
                continue;
            if (map[nr][nc] == 'S') {
                map[nr][nc] = '.';
                dfs(t + 1, nr, nc, sum + 1);
                map[nr][nc] = 'S';
            } else {
                dfs(t + 1, nr, nc, sum);
            }
        }
    }

    static boolean index(int r, int c) {
        return r < 0 || r >= R || c < 0 || c >= C;
    }
}