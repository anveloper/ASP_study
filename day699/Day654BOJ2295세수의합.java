package day699;

import java.io.*;
import java.util.*;

public class Day654BOJ2295세수의합 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, num[];

    N = Integer.parseInt(br.readLine());

    num = new int[N];

    for (int i = 0; i < N; i++) {
      num[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(num);

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < N; i++) {
      for (int j = i; j < N; j++) {
        set.add(num[i] + num[j]);
      }
    }

    for (int i = N - 1; 0 <= i; i--) {
      for (int j = 0; j < N; j++) {

        if (set.contains(num[i] - num[j])) {
          System.out.println(num[i]);
          return;
        }
      }
    }
  }
}