package day499;

import java.io.*;
import java.util.*;

public class Day455BOJ2304창고다각형 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int[] roof = new int[1001];
    int N = Integer.parseInt(br.readLine());
    int maxIndex = 0;
    int maxHeight = 0;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int index = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());
      if (maxHeight < height) {
        maxHeight = height;
        maxIndex = index;
      }
      roof[index] = height;
    }

    int answer = maxHeight;
    int moveMax = 0;
    for (int i = 0; i < maxIndex; i++) {
      if (moveMax < roof[i])
        moveMax = roof[i];
      answer += moveMax;
    }

    moveMax = 0;
    for (int i = 1000; i > maxIndex; i--) {
      if (moveMax < roof[i])
        moveMax = roof[i];
      answer += moveMax;
    }
    System.out.println(answer);
  }
}
