package day449;

import java.io.*;
import java.util.*;

public class Day412BOJ1240노드사이의거리 {
  static int N, M, cnt;
  static int[][] cost;
  static boolean flag;
  static boolean[] visited;
  static ArrayList<Integer>[] graph;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new ArrayList[N + 1];

    cost = new int[N + 1][N + 1];

    for (int i = 0; i < N + 1; i++) {
      graph[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
      cost[u][v] = c;
      cost[v][u] = c;
    }
    for (int i = 0; i < M; i++) {
      visited = new boolean[N + 1];
      st = new StringTokenizer(br.readLine());
      int e1 = Integer.parseInt(st.nextToken());
      int e2 = Integer.parseInt(st.nextToken());
      cnt = 0;
      flag = false;
      dfs(e1, e2);
      System.out.println(cnt);
    }
  }

  static void dfs(int index, int goal) {
    visited[index] = true;

    for (int node : graph[index]) {
      if (!visited[node]) {
        cnt += cost[index][node];
        if (node == goal) {
          flag = true;
          return;
        }
        dfs(node, goal);
        if (flag)
          return;
        cnt -= cost[index][node];
      }
    }
  }
}
