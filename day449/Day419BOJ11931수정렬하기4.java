package day449;

import java.io.*;
import java.util.*;

public class Day419BOJ11931수정렬하기4 {
  static int N;
  static PriorityQueue<Integer> pq;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < N; i++)
      pq.add(Integer.parseInt(br.readLine()));

    while (!pq.isEmpty())
      sb.append(pq.poll()).append("\n");

    System.out.println(sb);
    br.close();
  }
}
