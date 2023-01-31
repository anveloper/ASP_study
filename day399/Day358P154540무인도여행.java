import java.util.*;

public class Day358P154540무인도여행 {
    static String[] maps;
    static int N, M;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
    static List<Integer> ans;
    static boolean[][] visited;

    static int[] day358P154540무인도여행(String[] tmp) {
        maps = tmp;
        N = maps.length;
        M = maps[0].length();
        ans = new ArrayList<>();
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) == 'X')
                    continue;
                if (visited[i][j])
                    continue;
                visited[i][j] = true;
                ans.add(dfs(i, j));
            }
        }
        if (ans.size() == 0)
            return new int[] { -1 };
        return ans.stream().sorted().mapToInt(i -> i).toArray();
    }

    private static int dfs(int r, int c) {
        int tmp = maps[r].charAt(c) - '0';
        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (index(nr, nc))
                continue;
            if (maps[nr].charAt(nc) == 'X')
                continue;
            if (visited[nr][nc])
                continue;
            visited[nr][nc] = true;
            tmp += dfs(nr, nc);
        }
        return tmp;
    }

    private static boolean index(int nr, int nc) {
        return nr < 0 || nr >= N || nc < 0 || nc >= M;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(day358P154540무인도여행(new String[] { "X591X", "X1X5X", "X231X", "1XXX1" })));
    }
}
