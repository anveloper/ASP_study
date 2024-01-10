package day749;

import java.io.*;
import java.util.*;

public class Day709BOJ6996애너그램 {

  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int inNum = Integer.parseInt(bf.readLine());

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    if (inNum < 100) {
      for (int i = 1; i <= inNum; i++) {
        st = new StringTokenizer(bf.readLine(), " ");
        String a1 = st.nextToken();
        String a2 = st.nextToken();

        String[] a1Arr = a1.split("");
        Arrays.sort(a1Arr);
        String[] a2Arr = a2.split("");
        Arrays.sort(a2Arr);

        sb.append(a1 + " & " + a2);
        sb.append(
            (Arrays.toString(a1Arr).equals(Arrays.toString(a2Arr)))
                ? " are anagrams.\n"
                : " are NOT anagrams.\n");
      }
      bw.write(String.valueOf(sb));
    }

    bw.flush();
    bf.close();
    bw.close();
  }
}