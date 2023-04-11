package day449;

import java.io.*;
import java.util.*;

public class Day430BOJ15903카드합체놀이 {
  static int N, M;
  static long ans = 0;
  static PriorityQueue<Long> pq = new PriorityQueue<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++)
      pq.add(Long.parseLong(st.nextToken()));

    for (int i = 0; i < M; i++) {
      Long a = pq.poll();
      Long b = pq.poll();
      pq.add(a + b);
      pq.add(a + b);
    }

    while (!pq.isEmpty())
      ans += pq.poll();

    System.out.println(ans);
    br.close();
  }
}
