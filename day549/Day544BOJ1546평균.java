package day549;

import java.io.*;
import java.util.*;

public class Day544BOJ1546평균 {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    double arr[] = new double[Integer.parseInt(br.readLine())];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < arr.length; i++) {
      arr[i] = Double.parseDouble(st.nextToken());
    }

    double sum = 0;
    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      sum += ((arr[i] / arr[arr.length - 1]) * 100);
    }
    System.out.print(sum / arr.length);
  }
}