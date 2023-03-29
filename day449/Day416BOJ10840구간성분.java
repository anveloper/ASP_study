package day449;

import java.io.*;
import java.util.*;

public class Day416BOJ10840구간성분 {
  static final int P = 31;
  static final int SIZE = 26;
  static String str1, str2;
  static long[] pows;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    str1 = br.readLine();
    str2 = br.readLine();
    if (str1.length() > str2.length()) {
      String tmp = str1;
      str1 = str2;
      str2 = tmp;
    }

    pows = new long[SIZE];
    pows[0] = 1;
    for (int i = 1; i < SIZE; i++) {
      pows[i] = P * pows[i - 1];
    }

    int maxGap = 0;
    for (int pSize = 1; pSize < str1.length() + 1; pSize++) {
      Set<Long> setA = new HashSet<>();
      Set<Long> setB = new HashSet<>();

      boolean isSame = false;
      long hashA = 0, hashB = 0;
      for (int j = 0; j < str2.length() - pSize + 1; j++) {
        if (j == 0) {
          hashA = hash(str1, pSize);
          hashB = hash(str2, pSize);
        } else {
          if (j + pSize - 1 < str1.length()) {
            int aIdxLeft = str1.charAt(j - 1) - 'a';
            int aIdxRight = str1.charAt(j + pSize - 1) - 'a';
            hashA = j + pSize - 1 < str1.length() ? hashA - pows[aIdxLeft] + pows[aIdxRight] : hashA;
          }

          int bIdxLeft = str2.charAt(j - 1) - 'a';
          int bIdxRight = str2.charAt(j + pSize - 1) - 'a';
          hashB = hashB - pows[bIdxLeft] + pows[bIdxRight];
        }
        setA.add(hashA);
        setB.add(hashB);
      }

      int sum1 = setA.size() + setB.size();
      setA.addAll(setB);
      isSame = sum1 != setA.size();

      if (isSame) {
        maxGap = pSize;
      }
    }
    bw.write(String.valueOf(maxGap));
    br.close();
    bw.close();
  }

  public static long hash(String str, int end) {
    int[] table = new int[SIZE];
    for (int i = 0; i < end; i++) {
      table[str.charAt(i) - 'a']++;
    }

    long hash = 0;
    for (int i = 0; i < SIZE; i++) {
      hash = hash + table[i] * pows[i];
    }
    return hash;
  }
}
