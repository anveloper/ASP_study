package day449;

import java.io.*;
import java.util.*;

public class Day440BOJ24479알고리즘수업 {
  static int N, M, R, cnt;
  static int[] arr;
  static boolean[] visited;
  static ArrayList<ArrayList<Integer>> graph;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();
    arr = new int[N + 1];
    visited = new boolean[N + 1];

    for (int i = 0; i <= N; i++)
      graph.add(new ArrayList<>());

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    for (int i = 1; i <= N; i++)
      Collections.sort(graph.get(i));

    arr[R] = 1;
    visited[R] = true;
    cnt = 2;
    dfs(R);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++)
      sb.append(arr[i] + "\n");
    System.out.println(sb);
  }

  public static void dfs(int st) {
    for (int n : graph.get(st)) {
      if (!visited[n]) {
        arr[n] = cnt++;
        visited[n] = true;
        dfs(n);
      }
    }
  }
}
