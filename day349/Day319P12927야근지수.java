package day349;

import java.util.*;

class Day319P12927야근지수 {
    public long day319P12927야근지수(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int w : works) {
            pq.add(w);
        }

        while (n-- > 0) {
            int w = pq.poll();
            if (w == 0)
                break;
            else
                pq.add(--w);
        }

        long ans = 0;
        while (!pq.isEmpty()) {
            ans += Math.pow(pq.poll(), 2);
        }
        return ans;
    }
}
