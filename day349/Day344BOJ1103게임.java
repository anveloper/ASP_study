package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day344BOJ1103게임 {

    static char[][] map;
    static int[][] dp;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++)
                map[i][j] = line.charAt(j);
        }
        System.out.println(dfs(new Point(0, 0)));
    }

    public static int dfs(Point cur) {
        if (map[cur.x][cur.y] == 'H')
            return 0;
        else if (dp[cur.x][cur.y] > 0)
            return dp[cur.x][cur.y];
        visited[cur.x][cur.y] = true;
        for (int i = 0, step = map[cur.x][cur.y] - '0'; i < dx.length; i++) {
            int nextX = cur.x + dx[i] * step;
            int nextY = cur.y + dy[i] * step;
            try {
                if (visited[nextX][nextY]) {
                    System.out.println(-1);
                    System.exit(0);
                }
                dp[cur.x][cur.y] = max(dp[cur.x][cur.y], dfs(new Point(nextX, nextY)));
            } catch (Exception e) {
            }
        }
        visited[cur.x][cur.y] = false;
        return ++dp[cur.x][cur.y];
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}