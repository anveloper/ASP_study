package day399;

import java.io.*;
import java.util.*;

public class Day395BOJ1005ACMCraft { // g
  static final int MAX = 1001;
  static int N, K;
  static int[] buildTimes, indegs, minTimes;
  static ArrayList<ArrayList<Integer>> posteriors = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    for (int tc = readInt(); tc > 0; --tc) {
      N = readInt();
      K = readInt();
      indegs = new int[N + 1];
      minTimes = new int[N + 1];
      buildTimes = new int[N + 1];
      posteriors.clear();
      posteriors.add(null);
      for (int i = 1; i <= N; ++i) {
        posteriors.add(new ArrayList<>());
        buildTimes[i] = readInt();
      }

      for (; K > 0; --K) {
        int anterior = readInt();
        int posterior = readInt();
        indegs[posterior]++;
        posteriors.get(anterior).add(posterior);
      }

      int id = readInt();
      int minT = getMinTime(id);
      bw.write(minT + "\n");
    }
    bw.flush();
    bw.close();
  }

  static int getMinTime(int id) {
    Queue<Integer> q = new ArrayDeque<>();

    for (int i = 1; i <= N; ++i) {
      if (indegs[i] != 0)
        continue;
      if (i == id)
        return buildTimes[i];
      minTimes[i] = buildTimes[i];
      q.add(i);
    }

    LOOP: while (!q.isEmpty()) {
      int i = q.poll();
      for (int posterior : posteriors.get(i)) {
        minTimes[posterior] = Math.max(minTimes[i], minTimes[posterior]);
        if (--indegs[posterior] > 0)
          continue;
        minTimes[posterior] += buildTimes[posterior];
        if (posterior == id)
          break LOOP;
        q.add(posterior);
      }
    }
    return minTimes[id];
  }

  static int readInt() throws IOException {
    int val = 0;
    do {
      int c = System.in.read();
      if (c == ' ' || c == '\n')
        break;
      val = 10 * val + c - 48;
    } while (true);
    return val;
  }

}
