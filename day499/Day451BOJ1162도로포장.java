package day499;

import java.io.*;
import java.util.*;

public class Day451BOJ1162도로포장 {

  static int N, M, K;
  static List<Node>[] map;
  static long[][] cost;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    cost = new long[N + 1][K + 1];
    map = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++)
      map[i] = new ArrayList<>();

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      map[a].add(new Node(b, 0, c));
      map[b].add(new Node(a, 0, c));
    }

    dijkstra(1);
    System.out.println(Arrays.stream(cost[N]).min().getAsLong());
  }

  static void dijkstra(int start) {
    for (int i = 1; i <= N; i++)
      Arrays.fill(cost[i], Long.MAX_VALUE);

    cost[start][0] = 0;
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0, 0));

    while (!pq.isEmpty()) {
      Node now = pq.poll();
      if (now.cost > cost[now.node][now.cnt])
        continue;
      for (Node next : map[now.node]) {
        if (now.cnt < K && cost[next.node][now.cnt + 1] > cost[now.node][now.cnt]) {
          cost[next.node][now.cnt + 1] = cost[now.node][now.cnt];

          pq.add(new Node(next.node, now.cnt + 1, cost[next.node][now.cnt + 1]));
        }
        if (cost[next.node][now.cnt] > cost[now.node][now.cnt] + next.cost) {
          cost[next.node][now.cnt] = cost[now.node][now.cnt] + next.cost;
          pq.add(new Node(next.node, now.cnt, cost[next.node][now.cnt]));
        }
      }
    }
  }

  static class Node implements Comparable<Node> {
    int node, cnt;
    long cost;

    @Override
    public int compareTo(Node o) {
      return (int) (this.cost - o.cost);
    }

    public Node(int node, int cnt, long cost) {
      this.node = node;
      this.cnt = cnt;
      this.cost = cost;
    }
  }
}
