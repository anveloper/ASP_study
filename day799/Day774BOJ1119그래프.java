package day799;

import java.io.*;
import java.util.*;

public class Day774BOJ1119그래프 {
  static int count = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(bufferedReader.readLine());
    if (N == 1) {
      System.out.println(0);
      System.exit(0);
    }
    boolean[][] visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      String temp = bufferedReader.readLine();
      int tempCount = 0;
      for (int j = 0; j < N; j++) {
        visited[i][j] = temp.charAt(j) == 'Y' ? false : true;
        if (!visited[i][j]) {
          tempCount++;
        }
      }
      if (tempCount == 0) {
        System.out.println(-1);
        System.exit(0);
      }
    }
    boolean[] nodeVisited = new boolean[N];
    int road = 0;
    for (int i = 0; i < N; i++) {
      if (nodeVisited[i])
        continue;
      road++;
      dfs(i, new HashSet<>(), nodeVisited, visited);
    }
    if (count + 1 < road) {
      System.out.println(-1);
    } else {
      System.out.println(road - 1);
    }
  }

  static void dfs(int cur, HashSet<Integer> hashSet, boolean[] nodeVisited, boolean[][] visited) {
    nodeVisited[cur] = true;
    if (hashSet.contains(cur)) {
      count++;
    } else {
      hashSet.add(cur);
    }
    for (int i = 0; i < visited.length; i++) {
      if (!visited[cur][i]) {

        visited[cur][i] = true;
        visited[i][cur] = true;
        dfs(i, hashSet, nodeVisited, visited);
      }
    }
  }
}