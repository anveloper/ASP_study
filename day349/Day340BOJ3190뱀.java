package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day340BOJ3190뱀 {
    static int N, K, L, ans = 0, idx = 1, jdx = 1, dir = 0, n = 0;
    static int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };
    static int[][] map;
    static String[][] cmd;
    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        q = new LinkedList<>();
        map = new int[N + 2][N + 2];

        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < N + 2; j++) {
                if (i == 0 || j == 0 || i == N + 1 || j == N + 1)
                    map[i][j] = 1;
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
        }

        L = Integer.parseInt(br.readLine());
        cmd = new String[L][2];

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            cmd[i][0] = st.nextToken();
            cmd[i][1] = st.nextToken();
        }

        q.add(new int[] { idx, jdx });
        map[idx][jdx] = 1;
        while (true) {
            int t = Integer.parseInt(cmd[n][0]);
            char c = cmd[n][1].charAt(0);

            ans++;

            int nr = idx + dr[dir];
            int nc = jdx + dc[dir];

            if (map[nr][nc] == 1)
                break;
            else if (map[nr][nc] == 2) {
                q.add(new int[] { nr, nc });
                map[nr][nc] = 1;
            } else if (map[nr][nc] == 0) {
                q.add(new int[] { nr, nc });
                int[] tmp = q.poll();
                map[tmp[0]][tmp[1]] = 0;
            }
            idx = nr;
            jdx = nc;
            map[idx][jdx] = 1;

            if (ans == t) {
                if (c == 'D')
                    dir = (dir + 1) % 4;
                else if (c == 'L')
                    dir = (dir + 3) % 4;
                if (n + 1 < L)
                    n++;
            }
        }
        System.out.println(ans);
        br.close();
    }
}
