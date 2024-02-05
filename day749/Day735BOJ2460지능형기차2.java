package day749;

import java.io.*;
import java.util.*;

public class Day735BOJ2460지능형기차2 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int ans = 0;
    int tmp = 0;
    for (int i = 0; i < 10; i++) {
      st = new StringTokenizer(br.readLine());

      tmp = tmp - Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
      ans = Math.max(tmp, ans);
    }
    System.out.println(ans);
  }
}
