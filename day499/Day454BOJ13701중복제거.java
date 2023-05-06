package day499;

import java.io.*;
import java.util.*;

public class Day454BOJ13701중복제거 {
  static final int MAX = 33554432;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    BitSet bs = new BitSet(MAX);

    while (st.hasMoreTokens()) {
      int tmp = Integer.parseInt(st.nextToken());
      if (!bs.get(tmp)) {
        bs.set(tmp);
        bw.write(tmp + " ");
      }
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
