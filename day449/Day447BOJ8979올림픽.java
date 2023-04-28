package day449;

import java.io.*;
import java.util.*;

public class Day447BOJ8979올림픽 {
  static int N, K, ans;
  static int[][] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    arr = new int[N + 1][3];
    ans = 1;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int id = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[id][0] = g;
      arr[id][1] = s;
      arr[id][2] = b;
    }

    for (int i = 1; i <= N; i++) {
      if (arr[i][0] > arr[K][0])
        ans++;
      else if (arr[i][0] == arr[K][0] && arr[i][1] > arr[K][1])
        ans++;
      else if (arr[i][0] == arr[K][0] && arr[i][1] == arr[K][1] && arr[i][2] > arr[K][2])
        ans++;
    }
    bw.write(String.valueOf(ans));
    bw.flush();
    br.close();
    bw.close();
  }
}