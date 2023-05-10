package day499;

import java.io.*;
import java.util.*;

public class Day459BOJ1461도서관 {
  static int N, M, answer, max;
  static List<Integer> minus, plus;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 책의 개수
    M = Integer.parseInt(st.nextToken()); // 한번에 들 수 있는 책의 개수

    plus = new ArrayList<Integer>();
    minus = new ArrayList<Integer>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());

      if (max < Math.abs(num)) {
        max = Math.abs(num);
      }

      if (num > 0) {
        plus.add(num);
      } else {
        minus.add(Math.abs(num));
      }

    }

    Collections.sort(plus, Collections.reverseOrder());
    Collections.sort(minus, Collections.reverseOrder());

    for (int i = 0; i < plus.size(); i++) {
      if (i % M == 0 && plus.get(i) == max) {
        answer += plus.get(i);
      } else if (i % M == 0) {
        answer += (plus.get(i) * 2);
      }
    }

    for (int i = 0; i < minus.size(); i++) {
      if (i % M == 0 && minus.get(i) == max) {
        answer += minus.get(i);
      } else if (i % M == 0) {
        answer += (minus.get(i) * 2);
      }
    }

    System.out.println(answer);
  }
}
