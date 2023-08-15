package day599;

import java.io.*;
import java.util.*;

public class Day556BOJ1647도시분할계획 {
  static class Node implements Comparable<Node> {
    int idx;
    int weight;

    public Node(int idx, int weight) {
      this.idx = idx;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node e) {
      return this.weight - e.weight;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");

    int N = Integer.parseInt(inputs[0]);
    int M = Integer.parseInt(inputs[1]);

    ArrayList<Node>[] nodes = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      inputs = br.readLine().split(" ");
      int a = Integer.parseInt(inputs[0]);
      int b = Integer.parseInt(inputs[1]);
      int w = Integer.parseInt(inputs[2]);

      nodes[a].add(new Node(b, w));
      nodes[b].add(new Node(a, w));
    }

    boolean visited[] = new boolean[N + 1];

    int cnt = 0;
    int result = 0;
    int max_weight = 0;

    PriorityQueue<Node> q = new PriorityQueue<Node>();

    q.add(new Node(1, 0));

    while (true) {
      Node cur = q.poll();

      if (visited[cur.idx])
        continue;

      visited[cur.idx] = true;
      result += cur.weight;
      max_weight = Math.max(max_weight, cur.weight);
      cnt++;

      if (cnt == N)
        break;

      for (Node v : nodes[cur.idx]) {
        if (!visited[v.idx]) {
          q.add(new Node(v.idx, v.weight));
        }
      }
    }

    System.out.println(result - max_weight);
  }
}
