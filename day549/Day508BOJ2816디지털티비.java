package day549;

import java.io.*;

public class Day508BOJ2816디지털티비 {
  static int N, arrow;
  static String[] channels;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    channels = new String[N];

    for (int i = 0; i < N; i++) {
      channels[i] = br.readLine();
    }

    arrow = 0;
    for (int i = 0; i < N; i++) {
      if (channels[i].equals("KBS1")) {
        break;
      } else {
        arrow++;
        bw.append("1");
      }
    }

    while (!channels[0].equals("KBS1")) {
      swap(arrow, arrow - 1);
      bw.append("4");
    }

    for (int i = 0; i < N; i++) {
      if (channels[i].equals("KBS2")) {
        break;
      } else {
        arrow++;
        bw.append("1");
      }
    }

    while (!channels[1].equals("KBS2")) {
      swap(arrow, arrow - 1);
      bw.append("4");
    }

    bw.toString();
    bw.flush();
    bw.close();
  }

  private static void swap(int a, int b) {
    String tmp = channels[a];
    channels[a] = channels[b];
    channels[b] = tmp;
    arrow = b;
  }
}
