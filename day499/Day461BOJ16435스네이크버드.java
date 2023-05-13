package day499;

import java.util.*;
import java.io.*;

public class Day461BOJ16435스네이크버드 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < arr.length; i++)
      arr[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      if (L >= arr[i])
        ++L;
    }
    System.out.println(L);
    br.close();
  }
}
