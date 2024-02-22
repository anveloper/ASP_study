package day799;

import java.io.*;
import java.util.*;

public class Day752BOJ1145적어도대부분배수 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = 0;
    int cnt = 0;
    int[] arr = new int[5];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 5; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    while (true) {
      N++;
      for (int i = 0; i < 5; i++) {
        if (N >= arr[i] && N % arr[i] == 0)
          cnt++;
      }
      if (cnt > 2)
        break;
      cnt = 0;
    }
    System.out.println(N);
  }
}