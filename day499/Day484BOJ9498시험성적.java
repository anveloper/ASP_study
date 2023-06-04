package day499;

import java.io.*;

public class Day484BOJ9498시험성적 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int A = Integer.parseInt(br.readLine());
    System.out.print(
        (A >= 90)
            ? "A"
            : (A >= 80)
                ? "B"
                : (A >= 70)
                    ? "C"
                    : (A >= 60)
                        ? "D"
                        : "F");
  }
}
