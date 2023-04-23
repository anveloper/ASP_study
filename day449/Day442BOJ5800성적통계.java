package day449;

import java.io.*;
import java.util.*;

public class Day442BOJ5800성적통계 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();
    int K = Integer.parseInt(br.readLine());
    for (int i = 1; i <= K; i++)
      sb.append(solve(i, br.readLine())).append('\n');

    System.out.println(sb);
    br.close();
  }

  private static String solve(int classNum, String data) {
    StringTokenizer st = new StringTokenizer(data, " ");
    int cnt = Integer.parseInt(st.nextToken());
    int[] arr = new int[cnt];
    for (int i = 0; i < cnt; i++)
      arr[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(arr);

    int org = arr[arr.length - 1];
    int max = org;
    int min = org;
    int gap = -1;
    for (int i = arr.length - 2; i >= 0; i--) {
      int now = arr[i];
      max = Math.max(max, now);
      min = Math.min(min, now);
      gap = Math.max(gap, org - now);
      org = now;
    }

    StringBuilder res = new StringBuilder();
    res.append("Class " + classNum + '\n');
    res.append("Max " + max + ", ");
    res.append("Min " + min + ", ");
    res.append("Largest gap " + gap);

    return res.toString();
  }
}