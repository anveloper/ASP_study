package day799;

import java.io.*;
import java.math.BigInteger;

public class Day761BOJ1247부호 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 3; i++) {
      BigInteger S = new BigInteger("0");
      int N = Integer.parseInt(br.readLine());

      for (int j = 0; j < N; j++) {
        BigInteger N2 = new BigInteger(br.readLine());
        S = S.add(N2);
      }

      if (S.compareTo(BigInteger.ZERO) == -1) {
        System.out.println("-");
      } else if (S.compareTo(BigInteger.ZERO) == 1) {
        System.out.println("+");
      } else {
        System.out.println(0);
      }
    }
  }
}