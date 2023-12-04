package day699;

import java.util.*;

public class Day668BOJ9506약수들의합 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    while (true) {
      int n = sc.nextInt();
      if (n == -1)
        break;

      int[] arr = new int[n];
      int sum = 0;
      int index = 0;
      for (int i = 1; i < n; i++) {
        if (n % i == 0) {
          arr[index++] = i;
          sum += i;
        }
      }

      if (sum != n) {
        sb.append(n + " is NOT perfect.\n");
        continue;
      }

      sb.append(n + " = ");
      for (int i = 0; i < index; i++) {
        if (i == index - 1)
          sb.append(arr[i]);
        else
          sb.append(arr[i] + " + ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
    sc.close();
  }
}