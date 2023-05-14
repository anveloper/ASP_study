package day499;

import java.io.*;
import java.util.*;

public class Day463BOJ24480알고리즘수업깊이우선탐색2 {
  static StringBuilder sb = new StringBuilder();
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int[] check;
  static int cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    check = new int[n + 1];

    for (int i = 0; i < n + 1; i++) {
      graph.add(new ArrayList<Integer>());

    }
    while (m-- > 0) {
      st = new StringTokenizer(br.readLine(), " ");
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    for (int i = 1; i < graph.size(); i++) {
      Collections.sort(graph.get(i), Collections.reverseOrder());
    }

    cnt = 1;
    dfs(r);

    for (int i = 1; i < check.length; i++)
      sb.append(check[i]).append("\n");

    System.out.println(sb);
  }

  private static void dfs(int node) {
    check[node] = cnt;
    for (int i = 0; i < graph.get(node).size(); i++) {
      int newNode = graph.get(node).get(i);
      if (check[newNode] == 0) {
        cnt++;
        dfs(newNode);
      }
    }
  }
}
