package day499;

import java.io.*;
import java.util.*;

public class Day472BOJ3096영화제 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long ans = 0;
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    BitSet[] bs = new BitSet[n + 1];

    for (int i = 1; i <= n; ++i) {
      bs[i] = new BitSet(1001);
    }

    for (int i = 1; i <= m; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      bs[a].set(b);
    }

    for (int i = 1; i <= n; ++i) {
      for (int j = i + 1; j <= n; ++j) {
        BitSet set = new BitSet(1024);
        set.or(bs[i]);
        set.and(bs[j]);
        ans += (set.cardinality() * (set.cardinality() - 1)) / 2;
      }
    }

    bw.write(ans + "");
    bw.close();
  }
}
