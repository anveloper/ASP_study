package day599;

import java.io.*;
import java.util.*;

public class Day588BOJ5568카드놓기 {
  private String[] arr;
  private int n, k, v;
  private HashSet<String> chk = new HashSet<>();

  private void bf(int cnt, String cur) {
    if (cnt == k) {
      chk.add(cur);
      return;
    }
    for (int i = 0; i < n; i++) {
      if ((v & 1 << i) != 0)
        continue;
      v |= 1 << i;
      bf(cnt + 1, cur + arr[i]);
      v ^= 1 << i;
    }
  }

  private void solution() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());
    arr = new String[n];
    for (int i = 0; i < n; i++)
      arr[i] = br.readLine();

    bf(0, "");

    System.out.println(chk.size());
  }

  public static void main(String[] args) throws Exception {
    new Day588BOJ5568카드놓기().solution();
  }
}