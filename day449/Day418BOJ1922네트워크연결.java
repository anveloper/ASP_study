package day449;

import java.io.*;
import java.util.*;

public class Day418BOJ1922네트워크연결 {
  static int N, M, ans = 0;
  static int[] p;
  static ArrayList<Net> arr = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr.add(new Net(a, b, c));
    }

    p = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      p[i] = i;
    }

    Collections.sort(arr);

    for (Net network : arr) {
      if (find(network.cur) != find(network.next)) {
        ans += network.cost;
        union(network.cur, network.next);
      }
    }
    System.out.println(ans);
  }

  static int find(int x) {
    if (x == p[x]) {
      return x;
    }
    return p[x] = find(p[x]);
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      p[b] = a;
    }
  }

  static class Net implements Comparable<Net> {
    int cur;
    int next;
    int cost;

    Net(int current, int next, int cost) {
      this.cur = current;
      this.next = next;
      this.cost = cost;
    }

    @Override
    public int compareTo(Net o) {
      return this.cost - o.cost;
    }
  }
}
