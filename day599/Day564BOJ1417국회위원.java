package day599;

import java.io.*;
import java.util.*;

public class Day564BOJ1417국회위원 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int a = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    while (n-- > 1)
      pq.add(Integer.parseInt(br.readLine()));
    int cnt = 0;
    while (!pq.isEmpty() && pq.peek() >= a) {
      cnt++;
      a++;
      pq.add(pq.poll() - 1);
    }
    System.out.println(cnt);
  }
}