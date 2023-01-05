package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day332BOJ19640화장실의규칙 {
    static int N, M, K;
    static Queue<int[]>[] q;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        q = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            q[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int l = i % M;
            q[l].add(new int[] { d, h, l, i });
        }

        pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] < o2[0])
                return 1;
            else if (o1[0] == o2[0]) {
                if (o1[1] < o2[1])
                    return 1;
                else if (o1[1] == o2[1]) {
                    return o1[2] - o2[2];
                } else
                    return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        }); // 와우

        for (int i = 0; i < M; i++) {
            if (!q[i].isEmpty())
                pq.add(q[i].poll());
        }
        System.out.println(solve());
        br.close();
    }

    private static int solve() {
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[3] == K)
                break;
            if (!q[cur[2]].isEmpty())
                pq.add(q[cur[2]].poll());
            cnt++;
        }
        return cnt;
    }
}
