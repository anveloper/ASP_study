package day649;

import java.io.*;
import java.util.*;

public class Day631BOJ8980택배 {
  public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(in.readLine());

    Delivery info[] = new Delivery[M];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(in.readLine(), " ");
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cnt = Integer.parseInt(st.nextToken());
      info[i] = new Delivery(from, to, cnt);
    }
    Arrays.sort(info);

    int box[] = new int[N + 1];
    int max, possible, total = 0;
    for (int i = 0; i < M; i++) {
      int from = info[i].from;
      int to = info[i].to;
      int cnt = info[i].cnt;
      max = 0;
      for (int j = from; j < to; j++) {
        max = Math.max(max, box[j]);
      }
      possible = Math.min(C - max, cnt);
      total += possible;
      for (int j = from; j < to; j++) {
        box[j] += possible;
      }
    }
    System.out.println(total + box[N]);
  }

  static class Delivery implements Comparable<Delivery> {
    int from, to, cnt;

    public Delivery(int from, int to, int cnt) {
      this.from = from;
      this.to = to;
      this.cnt = cnt;
    }

    @Override
    public int compareTo(Delivery o) {
      if (this.to == o.to)
        return this.from - o.from;
      else
        return this.to - o.to;
    }
  }
}
