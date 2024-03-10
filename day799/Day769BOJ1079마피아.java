package day799;

import java.io.*;
import java.util.*;

public class Day769BOJ1079마피아 {
  static int N, num, ans = 0;
  static int[] guilty;
  static int[][] R;
  static boolean[] isLive;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    guilty = new int[N];
    R = new int[N][N];
    isLive = new boolean[N];

    Arrays.fill(isLive, true);

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      guilty[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        R[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    num = Integer.parseInt(br.readLine());
    dfs(N, 0);
    System.out.println(ans);
  }

  static void dfs(int cnt, int day) {
    if (!isLive[num] || cnt == 1) {
      ans = Math.max(ans, day);
      return;
    }

    if (cnt % 2 == 0) {
      for (int i = 0; i < N; i++) {
        if (!isLive[i] || i == num)
          continue;

        for (int j = 0; j < N; j++) {
          if (!isLive[j])
            continue;
          guilty[j] += R[i][j];
        }

        isLive[i] = false;
        dfs(cnt - 1, day + 1);
        isLive[i] = true;

        for (int j = 0; j < N; j++) {
          if (!isLive[j])
            continue;
          guilty[j] -= R[i][j];
        }
      }
    } else {
      int max = 0, idx = N - 1;

      for (int i = 0; i < N; i++) {
        if (isLive[i] && max < guilty[i]) {
          max = guilty[i];
          idx = i;
        } else if (isLive[i] && max == guilty[i]) {
          max = guilty[i];
          idx = Math.min(i, idx);
        }
      }

      isLive[idx] = false;
      dfs(cnt - 1, day);
      isLive[idx] = true;
    }
  }
}