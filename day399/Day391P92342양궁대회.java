package day399;

import java.util.Arrays;

public class Day391P92342양궁대회 {
  static int[] res = { -1 };
  static int[] lion;
  static int max = -1000;

  public static int[] solution(int n, int[] info) {
    lion = new int[11];
    dfs(n, info, 1);
    return res;
  }

  static void dfs(int n, int[] info, int cnt) {
    if (cnt == n + 1) {
      int apeach_point = 0;
      int lion_point = 0;
      for (int i = 0; i <= 10; i++) {
        if (info[i] != 0 || lion[i] != 0) {
          if (info[i] < lion[i])
            lion_point += 10 - i;
          else
            apeach_point += 10 - i;
        }
      }
      if (lion_point > apeach_point) {
        if (lion_point - apeach_point >= max) {
          res = lion.clone();
          max = lion_point - apeach_point;
        }
      }
      return;
    }
    for (int j = 0; j <= 10 && lion[j] <= info[j]; j++) {
      lion[j]++;
      dfs(n, info, cnt + 1);
      lion[j]--;
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(5, new int[] { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 })));
    System.out.println(Arrays.toString(solution(1, new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 })));
    System.out.println(Arrays.toString(solution(9, new int[] { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 })));
    System.out.println(Arrays.toString(solution(10, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3 })));
  }
}
