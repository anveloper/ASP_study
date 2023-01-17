package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day344BOJ1987알파벳 {
    static int R, C, ans = 0;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static char[][] map;
    static boolean[] check;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        check = new boolean[28];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        check[map[0][0] - 'A'] = true;

        dfs(0, 0, 1);
        System.out.println(ans);
        br.close();
    }

    private static void dfs(int r, int c, int cnt) {
        ans = Math.max(ans, cnt);
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (index(nr, nc))
                continue;
            if (check[map[nr][nc] - 'A'])
                continue;

            check[map[nr][nc] - 'A'] = true;
            dfs(nr, nc, cnt + 1);
            check[map[nr][nc] - 'A'] = false;
        }
    }

    private static boolean index(int nr, int nc) {
        return nr < 0 || nc < 0 || nr >= R || nc >= C;
    }
}