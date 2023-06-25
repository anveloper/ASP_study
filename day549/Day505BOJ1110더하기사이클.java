package day549;

import java.io.*;

public class Day505BOJ1110더하기사이클 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int cnt = 0;
    int copy = N;

    do {
      N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
      cnt++;
    } while (copy != N);

    System.out.println(cnt);
  }
}
