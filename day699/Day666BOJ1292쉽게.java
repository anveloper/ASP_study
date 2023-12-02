package day699;

import java.io.*;
import java.util.*;

public class Day666BOJ1292쉽게 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    int cnt = 0;
    int res = 0;

    for (int i = 1; i <= B; i++) {
      for (int j = 1; j <= i; j++) {
        cnt++;

        if (A <= cnt && cnt <= B) {
          res += i;
        }
      }
    }

    System.out.println(res);
  }
}
