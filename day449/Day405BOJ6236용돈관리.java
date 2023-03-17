package day449;

import java.io.*;
import java.util.*;

public class Day405BOJ6236용돈관리 {
  static int N, M;
  static int l = 1, r = (int) 1e9, ans = 0;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      l = Math.max(l, arr[i]);
    }

    while (l <= r) {
      int mid = (l + r) / 2;

      if (getCnt(mid) > M) {
        l = mid + 1;
      } else {
        ans = mid;
        r = mid - 1;
      }
    }

    System.out.println(ans);
    br.close();
  }

  static int getCnt(int mid) {
    int remain = mid;
    int cnt = 1;

    for (int i = 0; i < N; i++) {
      if (remain - arr[i] < 0) {
        remain = mid;
        cnt++;
      }

      remain -= arr[i];
    }

    return cnt;
  }
}