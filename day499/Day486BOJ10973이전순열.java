package day499;

import java.io.*;
import java.util.*;

public class Day486BOJ10973이전순열 {
  static int N;
  static int[] sequence;
  static boolean[] visited;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    sequence = new int[N + 1];
    visited = new boolean[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      sequence[i] = Integer.parseInt(st.nextToken());
      visited[sequence[i]] = true;
    }

    StringBuilder result = new StringBuilder();
    if (check()) {
      for (int i = 1; i <= N; i++) {
        result.append(sequence[i]).append(" ");
      }
      System.out.println(result);
      return;
    }
    System.out.println(-1);
  }

  static boolean check() {
    for (int i = N; i >= 2; i--) {
      visited[sequence[i]] = false;
      if (sequence[i] < sequence[i - 1]) {
        visited[sequence[i - 1]] = false;
        sequence[i - 1]--;
        for (int j = sequence[i - 1]; j >= 1; j--) {
          if (visited[j]) {
            continue;
          }
          sequence[i - 1] = j;
          break;
        }
        visited[sequence[i - 1]] = true;
        visit(i);
        return true;
      }
    }
    return false;
  }

  static void visit(int idx) {

    for (int i = N; i >= 1; i--) {
      if (visited[i]) {
        continue;
      }
      sequence[idx++] = i;
      visited[i] = true;
    }
  }
}
