package day799;

import java.util.*;

public class Day765BOJ1267핸드폰요금 {

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K;
    int YoungSik = 0, MinSik = 0;
    for (int i = 0; i < N; i++) {
      K = sc.nextInt();
      YoungSik += ((K / 30) + 1) * 10;
      MinSik += ((K / 60) + 1) * 15;

    }
    if (YoungSik == MinSik) {
      System.out.println("Y M " + YoungSik);
    } else if (YoungSik < MinSik) {
      System.out.println("Y " + YoungSik);
    } else if (YoungSik > MinSik) {
      System.out.println("M " + MinSik);
    }
    sc.close();
  }
}
