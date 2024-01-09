package day749;

import java.io.*;
import java.util.*;

public class Day708BOJ2845파티뒤 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int l = Integer.parseInt(st.nextToken());
    int p = Integer.parseInt(st.nextToken());
    int num = l * p;
    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (st.hasMoreTokens()) {
      int n = Integer.parseInt(st.nextToken());
      sb.append(n - num + " ");
    }
    System.out.print(sb);
  }
}