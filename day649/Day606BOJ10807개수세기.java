package day649;

import java.io.*;
import java.util.*;

public class Day606BOJ10807개수세기 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int count = 0;
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int b = Integer.parseInt(br.readLine());

    for (int j = 0; j < arr.length; j++) {
      if (b == arr[j]) {
        count++;
      }
    }
    System.out.println(count);

    br.close();
  }
}