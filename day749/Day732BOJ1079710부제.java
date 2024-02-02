package day749;

import java.io.*;
import java.util.*;

public class Day732BOJ1079710부제 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int cnt = 0;
    while (st.hasMoreTokens()) {
      if (n == Integer.parseInt(st.nextToken()))
        cnt++;
    }
    System.out.print(cnt);
  }
}