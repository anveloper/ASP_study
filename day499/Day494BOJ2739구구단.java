package day499;

import java.io.*;

public class Day494BOJ2739구구단 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for (int i = 1; i < 10; i++) {
      sb.append(a).append(' ').append('*').append(' ').append(i);
      sb.append(' ').append('=').append(' ').append(a * i).append('\n');
    }
    System.out.print(sb);
    br.close();
  }
}