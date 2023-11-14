package day649;

import java.io.*;

public class Day648BOJ4470줄번호 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    for (int i = 1; i <= N; i++) {
      String name = br.readLine();
      sb.append(i + "." + " " + name).append("\n");
    }
    System.out.println(sb);
  }
}
