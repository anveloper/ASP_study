
import java.util.*;
import java.io.*;

public class Day361BOJ1202보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[][] items = new int[n][2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] mv = br.readLine().split(" ");
            items[i][0] = Integer.parseInt(mv[0]);
            items[i][1] = Integer.parseInt(mv[1]);
        }

        Arrays.sort(items, (int[] a1, int[] a2) -> {
            if (a1[1] == a2[1])
                return a1[0] - a2[0];
            else
                return a2[1] - a1[1];
        });

        for (int i = 0; i < k; i++) {
            int weight = Integer.parseInt(br.readLine());
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            int weight = items[i][0];
            int value = items[i][1];
            if (map.ceilingKey(weight) == null)
                continue;
            int temp = map.ceilingKey(weight);
            int count = map.get(temp);
            if (count > 1)
                map.put(temp, count - 1);
            else
                map.remove(temp);
            sum += value;
        }
        System.out.print(sum);
    }
}
