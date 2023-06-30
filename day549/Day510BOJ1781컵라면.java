package day549;

import java.util.*;
import java.io.*;

public class Day510BOJ1781컵라면 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<int[]> al = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      al.add(new int[] { a, b });
    }

    Collections.sort(al, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] > o2[0]) {
          return 1;
        } else if (o1[0] < o2[0]) {
          return -1;
        } else {
          return 0;
        }
      }
    });

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      pq.offer(al.get(i)[1]);
      if (pq.size() > al.get(i)[0]) {
        pq.poll();
      }
    }

    int ans = 0;
    while (!pq.isEmpty()) {
      ans += pq.poll();
    }
    System.out.println(ans);
  }
}
