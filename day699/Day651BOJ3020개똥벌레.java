package day699;

import java.io.*;
import java.util.*;

public class Day651BOJ3020개똥벌레 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    int[] down = new int[H + 2];
    int[] up = new int[H + 2];
    for (int i = 1; i <= (N) / 2; i++) {
      int a = Integer.parseInt(br.readLine());
      int b = H - Integer.parseInt(br.readLine()) + 1;
      down[a]++;
      up[b]++;
    }
    for (int i = 1; i <= H; i++) {
      down[i] += down[i - 1];
    }

    for (int i = H; i >= 1; i--) {
      up[i] += up[i + 1];
    }

    int min = N;
    int cnt = 0;
    for (int i = 1; i < H + 1; i++) {
      int dif = (down[H] - down[i - 1]) + (up[1] - up[i + 1]);

      if (dif < min) {
        min = dif;
        cnt = 1;
      } else if (dif == min)
        cnt++;
    }
    System.out.println(min + " " + cnt);
  }
}