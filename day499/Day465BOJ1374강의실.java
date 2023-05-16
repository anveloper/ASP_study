package day499;

import java.io.*;
import java.util.*;

public class Day465BOJ1374강의실 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    PriorityQueue<Integer> rooms = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] lecture = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()) };
      pq.offer(lecture);
    }

    int ans = 0;
    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      while (!rooms.isEmpty() && rooms.peek() <= cur[1]) {
        rooms.poll();
      }
      rooms.offer(cur[2]);
      ans = Math.max(ans, rooms.size());
    }
    System.out.print(ans);
  }
}
