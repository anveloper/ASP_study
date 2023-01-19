package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day346BOJ11559뿌요뿌요 {
    static int N = 12, M = 6, ans = 0;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static char[][] map = new char[N][M];
    static boolean changed;
    static boolean[][] visited;
    static List<int[]> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }
        while (true) {
            changed = false;
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    char c = map[i][j];
                    if (c != '.') {
                        list = new ArrayList<>();
                        bfs(c, i, j);
                        if (list.size() >= 4) {
                            changed = true;
                            for (int[] a : list)
                                map[a[0]][a[1]] = '.';
                        }
                    }
                }
            }
            if (!changed)
                break;
            change();
            // print();
            ans++;
        }
        System.out.println(ans);
        br.close();
    }

    private static void print() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(char c, int idx, int jdx) {
        Queue<int[]> q = new LinkedList<>();
        list.add(new int[] { idx, jdx });
        q.add(new int[] { idx, jdx });
        visited[idx][jdx] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = cur[0] + dr[dir];
                int nc = cur[1] + dc[dir];
                if (index(nr, nc))
                    continue;
                if (visited[nr][nc])
                    continue;
                if (map[nr][nc] != c)
                    continue;
                list.add(new int[] { nr, nc });
                q.add(new int[] { nr, nc });
                visited[nr][nc] = true;
            }
        }
    }

    private static boolean index(int nr, int nc) {
        return nr < 0 || nr >= N || nc < 0 || nc >= M;
    }

    private static void change() {
        for (int j = 0; j < M; j++)
            for (int i = N - 1; i > 0; i--)
                if (map[i][j] == '.')
                    for (int k = i - 1; k >= 0; k--)
                        if (map[k][j] != '.') {
                            map[i][j] = map[k][j];
                            map[k][j] = '.';
                            break;
                        }
    }
}
