package day549;

import java.io.*;

public class Day539BOJ14713앵무새 {
  static int N, cnt = 0;
  static String[] L;
  static String[][] arr;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    arr = new String[N][];
    for (int i = 0; i < N; i++) {
      arr[i] = br.readLine().split(" ");
      cnt += arr[i].length;
    }
    L = br.readLine().split(" ");

    if (L.length != cnt)
      System.out.print("Impossible");
    else
      System.out.print(isPossible());
  }

  static String isPossible() {
    int[] idx = new int[N];
    for (String w : L) {
      boolean flag = false;
      for (int j = 0; j < N; j++) {
        if (idx[j] == arr[j].length)
          continue;
        if (w.equals(arr[j][idx[j]])) {
          idx[j]++;
          flag = true;
          break;
        }
      }
      if (!flag)
        return "Impossible";
    }
    return "Possible";
  }
}
