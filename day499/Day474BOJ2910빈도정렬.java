package day499;

import java.io.*;
import java.util.*;

public class Day474BOJ2910빈도정렬 {
  static int N, C;
  static LinkedHashMap<String, Integer> hashMapList, result;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    hashMapList = new LinkedHashMap<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      String str = st.nextToken();
      if (hashMapList.containsKey(str)) {
        int cnt = hashMapList.get(str) + 1;
        hashMapList.put(str, cnt);
      } else {
        hashMapList.put(str, 1);
      }
    }

    result = sortMapByValue(hashMapList, 1);
    Object[] key = result.keySet().toArray();
    for (int i = 0; i < key.length; i++) {
      int cnt = result.get(key[i]);
      while (cnt > 0) {
        bw.write(key[i] + " ");
        cnt--;
      }
    }
    bw.flush();
    br.close();
    bw.close();
  }

  public static LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map, Integer orderBy) {
    List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
    if (orderBy == 0) {
      Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
    } else {
      Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
    }

    LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
    for (Map.Entry<String, Integer> entry : entries) {
      result.put(entry.getKey(), entry.getValue());
    }
    return result;
  }
}
