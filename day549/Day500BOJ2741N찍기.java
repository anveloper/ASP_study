package day549;

import java.io.*;

public class Day500BOJ2741N찍기 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    br.close();

    int i = 1;
    StringBuilder sb = new StringBuilder();

    while (i <= N) {
      sb.append(i + "\n");
      i++;
    }
    System.out.println(sb);
  }
}
