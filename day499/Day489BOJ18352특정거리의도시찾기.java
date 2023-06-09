package day499;

import java.io.*;
import java.util.*;

public class Day489BOJ18352특정거리의도시찾기 {
  static class Node {
    int no;
    Node next;

    public Node(int no, Node next) {
      this.no = no;
      this.next = next;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    Node[] nodes = new Node[n + 1];
    for (int i = 1; i <= n; i++) {
      nodes[i] = new Node(i, null);
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      nodes[a].next = new Node(b, nodes[a].next);
    }

    System.out.print(bfs(nodes, k, x));
  }

  private static String bfs(Node[] nodes, int k, int x) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[nodes.length];
    q.add(x);
    visited[x] = true;

    for (int i = 0; i < k; i++) {
      Queue<Integer> next = new LinkedList<>();
      while (!q.isEmpty()) {
        int cur = q.poll();
        for (Node node = nodes[cur]; node != null; node = node.next) {
          if (!visited[node.no]) {
            next.add(node.no);
            visited[node.no] = true;
          }
        }
      }
      q = next;
    }
    if (q.size() == 0)
      return "-1";

    int[] arr = new int[q.size()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = q.remove();
    }
    Arrays.sort(arr);
    StringBuilder sb = new StringBuilder();
    for (int i : arr) {
      sb.append(i + "\n");
    }
    return sb.toString();
  }
}
