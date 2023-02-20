package day399;

import java.io.*;
import java.util.*;

public class Day378BOJ1253좋다 {
  static int N, ans = 0;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(arr);
    for (int i = 0; i < N; i++) {
      int l = 0, r = N - 1, num = arr[i];
      while (l < r) {
        int tmp = arr[l] + arr[r];
        if (tmp < num)
          l++;
        else if (tmp > num)
          r--;
        else {
          if (l == i)
            l++;
          else if (r == i)
            r--;
          else {
            ans++;
            break;
          }
        }
      }
    }
    System.out.println(ans);
    br.close();
  }
}
