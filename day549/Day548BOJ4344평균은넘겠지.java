package day549;

import java.io.*;
import java.util.*;

public class Day548BOJ4344평균은넘겠지 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] arr;

    int testcase = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for (int i = 0; i < testcase; i++) {

      st = new StringTokenizer(br.readLine(), " ");

      int N = Integer.parseInt(st.nextToken());
      arr = new int[N];

      double sum = 0;

      for (int j = 0; j < N; j++) {
        int val = Integer.parseInt(st.nextToken());
        arr[j] = val;
        sum += val;
      }

      double mean = (sum / N);
      double count = 0;

      for (int j = 0; j < N; j++) {
        if (arr[j] > mean) {
          count++;
        }
      }

      System.out.printf("%.3f%%\n", (count / N) * 100);

    }
  }
}