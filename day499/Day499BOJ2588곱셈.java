package day499;

import java.io.*;

public class Day499BOJ2588곱셈 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int A = Integer.parseInt(br.readLine());
    String B = br.readLine();
    char[] b = B.toCharArray();

    sb.append(A * (b[2] - '0')).append("\n");
    sb.append(A * (b[1] - '0')).append("\n");
    sb.append(A * (b[0] - '0')).append("\n");
    sb.append(A * Integer.parseInt(B)).append("\n");
    System.out.println(sb);
  }
}