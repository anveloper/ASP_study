package day499;

import java.io.*;

public class Day479BOJ9658돌게임4 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());

    bw.write((N % 7 == 1 || N % 7 == 3) ? "CY" : "SK");
    bw.flush();
    bw.close();
    br.close();
  }
}
