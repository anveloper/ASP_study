package day749;

import java.io.*;
import java.util.*;

public class Day719BOJ1246온라인판매 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    ArrayList<Integer> client = new ArrayList<Integer>();
    for (int i = 0; i < m; i++) {
      client.add(Integer.parseInt(br.readLine()));
    }
    int ans = 0;
    int idx = 0;

    Collections.sort(client);

    for (int i = 0; i < client.size(); i++) {
      int tmp = client.get(i);
      int sum = 0;

      if (m - i < n) {
        sum = tmp * (m - i);
      } else {
        sum = tmp * n;
      }

      if (sum > ans) {
        ans = sum;
        idx = tmp;
      }
    }
    System.out.println(idx + " " + ans);
  }
}