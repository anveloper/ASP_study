package day649;

import java.io.*;
import java.util.*;

public class Day607BOJ10810공넣기 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];

    int M = Integer.parseInt(st.nextToken());
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int I = Integer.parseInt(st.nextToken());
      int J = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      Arrays.fill(arr, I - 1, J, K);
    }

    for (int k = 0; k < arr.length; k++) {
      bw.write(arr[k] + " ");
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
