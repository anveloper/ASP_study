package day399;

import java.io.*;
import java.util.*;

public class Day379BOJ2352반도체설계 {
  static int N, ans = 0;
  static int[] arr, lis;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = null;

    N = Integer.parseInt(br.readLine());
    arr = new int[N + 1];
    lis = new int[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i < N + 1; i++)
      arr[i] = Integer.parseInt(st.nextToken());

    lis[1] = arr[1];
    for (int i = 1; i < N + 1; i++) {
      if (i == 1 || arr[i] > lis[ans - 1])
        lis[ans++] = arr[i];
      else {
        int l = 0, r = ans, idx = ans;
        while (l < r) {
          int mid = (l + r) / 2;
          if (lis[mid] < arr[i])
            l = mid + 1;
          else {
            idx = Math.min(idx, mid);
            r = mid;
          }
        }
        lis[idx] = arr[i];
      }
    }
    System.out.println(ans);
    br.close();
  }
}
