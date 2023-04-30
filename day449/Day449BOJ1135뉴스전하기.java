package day449;

import java.io.*;
import java.util.*;

public class Day449BOJ1135뉴스전하기 {

  static int N;
  static int[] arr, dp;
  static boolean[] used;
  static ArrayList<Integer>[] list;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    st.nextToken();
    list = new ArrayList[N];
    for (int i = 0; i < N; i++)
      list[i] = new ArrayList<>();
    for (int i = 1; i < N; i++)
      list[Integer.parseInt(st.nextToken())].add(i);

    dp = new int[N];
    arr = new int[N];
    used = new boolean[N];
    Arrays.fill(dp, -1);
    System.out.print(dfs(0));
  }

  public static int dfs(int now) {
    ArrayList<Integer> tmp = new ArrayList<>();
    for (int num : list[now]) {
      tmp.add(dfs(num));
    }

    int result = 0;
    Collections.sort(tmp, Collections.reverseOrder());
    for (int i = 0; i < list[now].size(); i++) {
      result = Math.max(result, i + 1 + tmp.get(i));
    }
    return result;
  }
}