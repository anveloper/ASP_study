package day799;

import java.io.*;
import java.util.*;

public class Day772BOJ1114통나무자르기 {
  static long l;
  static int k, c;
  static long[] cut;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    l = Long.parseLong(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    cut = new long[k + 2];
    cut[0] = 0;
    cut[1] = l;

    st = new StringTokenizer(br.readLine());
    for (int i = 2; i < k + 2; i++) {
      cut[i] = Long.parseLong(st.nextToken());
    }
    Arrays.sort(cut);

    long L = 0, R = l;
    long ansWood = l, ansPos = 0;
    while (L <= R) {
      long mid = (L + R) / 2;
      int cnt = 0;
      long cutPos = 0;
      long len = 0;

      for (int i = k; i >= 0; i--) {
        len += cut[i + 1] - cut[i];

        if (len > mid) {
          len = cut[i + 1] - cut[i];
          cnt++;

          if (len > mid) {
            cnt = c + 1;
            break;
          }
        }
      }

      if (cnt <= c) {
        cutPos = cut[1];

        if (cnt == c)
          cutPos = len;

        ansWood = Math.min(mid, ansWood);
        ansPos = cutPos;
        R = mid - 1;
      } else {
        L = mid + 1;
      }
    }

    System.out.println(ansWood + " " + ansPos);
  }
}