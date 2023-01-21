package day349;

import java.io.*;
import java.util.*;

public class Day348BOJ13334철로 {
    static int N, d, ans = -1;
    static List<int[]> list;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            list.add(h < o ? new int[] { h, o } : new int[] { o, h });
        }
        d = Integer.parseInt(br.readLine());

        list.sort((o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            else
                return o1[1] - o2[1];
        });

        for (int i = 0; i < N; i++) {
            int[] cur = list.get(i);
            pq.add(cur[0]);
            while (!pq.isEmpty()) {
                if (pq.peek() >= cur[1] - d)
                    break;
                pq.poll();
            }
            ans = Math.max(ans, pq.size());
        }
        System.out.println(ans);
        br.close();
    }
}
