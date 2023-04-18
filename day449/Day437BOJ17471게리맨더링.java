package day449;

import java.io.*;
import java.util.*;

public class Day437BOJ17471게리맨더링 {
  static final int INF = 999_999_999;
  static int N, ans = INF, tot = 0;
  static int[] arr;
  static int[][] map;
  static boolean[] selected;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    selected = new boolean[N];
    map = new int[N][N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      tot += arr[i];
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int cnt = Integer.parseInt(st.nextToken());
      for (int j = 0; j < cnt; j++) {
        map[i][Integer.parseInt(st.nextToken()) - 1] = 1;
      }
    }

    dfs(0, 0, 0);
    System.out.println(ans == INF ? -1 : ans);
    br.close();
  }

  public static void dfs(int st, int cnt, int sum) {
    if (1 <= cnt && cnt <= N / 2) {
      int diff = Math.abs(sum - (tot - sum));
      if (ans > diff) {
        if (bfs(true, cnt) && bfs(false, N - cnt)) {
          ans = diff;
        }
      }
      if (cnt == N / 2)
        return;
    }

    for (int i = st; i < N; i++) {
      selected[i] = true;
      dfs(i + 1, cnt + 1, sum + arr[i]);
      selected[i] = false;
    }
  }

  public static boolean bfs(boolean b, int cnt) {
    if (cnt == 1)
      return true;

    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[N];
    for (int i = 0; i < N; i++) {
      if (selected[i] == b) {
        visited[i] = true;
        q.offer(i);
        break;
      }
    }
    cnt--;

    while (!q.isEmpty()) {
      int n = q.poll();
      for (int i = 0; i < N; i++) {
        if (selected[i] == b && map[n][i] == 1 && !visited[i]) {
          visited[i] = true;
          cnt--;
          q.offer(i);
        }
      }
    }

    return cnt == 0;
  }
}
