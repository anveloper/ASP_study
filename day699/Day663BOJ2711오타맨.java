package day699;

import java.io.*;
import java.util.*;

public class Day663BOJ2711오타맨 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken()) - 1;
      String str = st.nextToken();
      sb.append(str, 0, idx).append(str, idx + 1, str.length()).append("\n");
    }
    System.out.println(sb);
  }
}