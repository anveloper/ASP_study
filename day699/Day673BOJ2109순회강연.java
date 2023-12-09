package day699;

import java.io.*;
import java.util.*;

public class Day673BOJ2109순회강연 {
  static int N;
  static ArrayList<Integer>[] al;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    al = new ArrayList[10001];

    for (int i = 1; i < 10001; i++) {
      al[i] = new ArrayList<>();
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      int pay = Integer.parseInt(st.nextToken());
      int days = Integer.parseInt(st.nextToken());

      al[days].add(pay);
    }

    int result = 0;
    for (int i = 10000; i > 0; i--) {
      for (int j = 0; j < al[i].size(); j++) {
        pq.add(al[i].get(j));
      }
      if (!pq.isEmpty())
        result += pq.poll();
    }

    System.out.println(result);
  }
}
