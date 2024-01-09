package day749;

import java.io.*;
import java.util.*;

public class Day708BOJ2845파티뒤 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      sb.append(Integer.parseInt(st.nextToken()) - N + " ");
    }
    System.out.print(sb);
  }
}