package day549;

import java.io.*;

public class Day506BOJ2742기찍N {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    br.close();
    StringBuilder sb = new StringBuilder();

    while (N > 0) {
      sb.append(N + "\n");
      N--;
    }
    System.out.println(sb);
  }
}
