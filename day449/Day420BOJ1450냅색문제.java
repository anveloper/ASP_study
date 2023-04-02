package day449;

import java.io.*;
import java.util.*;

public class Day420BOJ1450냅색문제 {
  static int N, C, cnt = 0, idx = 0;
  static int[] arr;
  static List<Integer>[] list;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(st.nextToken());

    list = new ArrayList[] { new ArrayList<>(), new ArrayList<>() };
    recur(0, 0, 0);
    recur(1, N / 2, 0);

    list[1].sort((o1, o2) -> (o1 - o2));

    for (int i = 0; i < list[0].size(); i++) {
      idx = -1;
      birnarySearch(0, list[1].size() - 1, list[0].get(i));
      cnt += idx + 1;
    }
    System.out.println(cnt);
    br.close();
  }

  private static void birnarySearch(int l, int r, int value) {
    while (l <= r) {
      int mid = (l + r) / 2;
      if (list[1].get(mid) + value <= C) {
        idx = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
  }

  private static void recur(int t, int i, int sum) {
    int n = N;
    if (t == 0)
      n /= 2;
    if (sum > C)
      return;
    if (i == n) {
      list[t].add(sum);
      return;
    }
    recur(t, i + 1, sum);
    recur(t, i + 1, sum + arr[i]);
  }
}
