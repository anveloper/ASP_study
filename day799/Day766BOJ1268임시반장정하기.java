package day799;

import java.io.*;
import java.util.*;

public class Day766BOJ1268임시반장정하기 {

  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(bf.readLine());
    int[][] arr = new int[n][5];
    int max = 0;
    int ans = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < 5; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < n; i++) {
      Set<Integer> sameClass = new HashSet<>();

      for (int j = 0; j < 5; j++) {
        for (int k = 0; k < n; k++) {
          if (arr[i][j] == arr[k][j] && k != i) {
            sameClass.add(k);
          }
        }
      }

      if (max < sameClass.size()) {
        max = sameClass.size();
        ans = i;
      }
    }
    System.out.println(ans + 1);
    bf.close();
  }
}