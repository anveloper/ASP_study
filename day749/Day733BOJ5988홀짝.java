package day749;

import java.io.*;

public class Day733BOJ5988홀짝 {
  public static void main(String[] argv) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String x = (br.readLine());
      sb.append((x.charAt(x.length() - 1) % 2 == 0) ? "even" : "odd").append("\n");
    }
    System.out.println(sb);
  }
}