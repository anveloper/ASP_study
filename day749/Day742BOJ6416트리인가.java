package day749;

import java.io.*;
import java.util.*;

public class Day742BOJ6416트리인가 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> vertex = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    outer: for (int tc = 1;; tc++) {
      map = new HashMap<>();
      vertex = new HashSet<>();
      boolean flag = false;

      st = new StringTokenizer(br.readLine());
      while (true) {
        if (!st.hasMoreTokens()) {
          st = new StringTokenizer(br.readLine());
        }
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a == 0)
          break;
        if (a == -1)
          break outer;

        if (!vertex.add(b)) {
          flag = true;
        }
        map.put(a, map.getOrDefault(a, 0) + 1);
      }

      if (vertex.size() != 0) {
        int rootNum = 0;
        for (int num : map.keySet()) {
          if (!vertex.contains(num))
            rootNum++;
        }
        if (rootNum != 1)
          flag = true;
      }
      sb.append("Case " + (tc) + ((flag) ? " is not a tree.\n" : " is a tree.\n"));
    }
    System.out.println(sb.toString());
  }
}