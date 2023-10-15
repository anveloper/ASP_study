package day649;

import java.io.*;

public class Day619BOJ1011플라이알파 {
  public static void main(String[] args) throws Exception {
    BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    for (int n = Integer.parseInt(re.readLine()); n > 0; n--) {
      String[] input = re.readLine().split(" ");
      int distance = Integer.parseInt(input[1]) - Integer.parseInt(input[0]);
      int maxDiff = (int) Math.sqrt(distance);
      if (distance == maxDiff * maxDiff) {
        sb.append(maxDiff * 2 - 1);
      } else if (distance <= maxDiff * (maxDiff + 1)) {
        sb.append(maxDiff * 2);
      } else {
        sb.append(maxDiff * 2 + 1);
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }
}