package day549;

import java.io.*;
import java.util.*;

public class Day535BOJ1045도로 {
  private static class Edge implements Comparable<Edge> {
    int a, b;

    Edge(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public int compareTo(Edge o) {
      if (a == o.a) {
        return Integer.compare(b, o.b);
      }
      return Integer.compare(a, o.a);
    }
  }

  private static int[] P;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    PriorityQueue<Edge> edges1 = new PriorityQueue<>();
    PriorityQueue<Edge> edges2 = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      char[] line = br.readLine().toCharArray();
      for (int j = i + 1; j < N; j++) {
        if (line[j] == 'Y') {
          edges1.offer(new Edge(i, j));
        }
      }
    }

    // MST!
    int cnt = 0;
    P = new int[N];
    for (int i = 0; i < N; i++)
      P[i] = i;

    int[] ans = new int[N];

    while (!edges1.isEmpty()) {
      Edge e = edges1.poll();
      int pu = find(e.a);
      int pv = find(e.b);
      if (pu != pv) {
        M--;
        cnt++;
        P[pv] = pu;
        ans[e.a]++;
        ans[e.b]++;
      } else {
        edges2.offer(e);
      }
    }

    while (M > 0 && !edges2.isEmpty()) {
      Edge e = edges2.poll();
      ans[e.a]++;
      ans[e.b]++;
      M--;
    }

    StringBuilder sb = new StringBuilder();
    if (M != 0 || cnt != N - 1) {
      sb.append(-1);
    } else {
      for (int i = 0; i < N; i++) {
        if (i == 0)
          sb.append(ans[i]);
        else
          sb.append(" ").append(ans[i]);
      }
    }
    System.out.println(sb);
  }

  private static int find(int a) {
    if (P[a] == a)
      return a;
    return P[a] = find(P[a]);
  }
}
