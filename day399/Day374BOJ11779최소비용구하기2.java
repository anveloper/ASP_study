import java.util.*;
import java.io.*;

public class Day374BOJ11779최소비용구하기2 {
    static int N, M, S, E;
    static ArrayList<Integer> list;
    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, c));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        for (int i = 0; i <= N; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[S] = 0;

        int[] pre = new int[N + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(S, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.idx == E) {
                sb.append(dist[E] + "\n");
                break;
            }

            if (cur.cost > dist[cur.idx])
                continue;

            for (int i = 0; i < graph.get(cur.idx).size(); i++) {
                Node next = graph.get(cur.idx).get(i);

                if (dist[next.idx] > cur.cost + next.cost) {
                    dist[next.idx] = cur.cost + next.cost;
                    pre[next.idx] = cur.idx;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        list = new ArrayList<>();
        while (true) {
            if (pre[E] == 0)
                break;
            list.add(E);
            E = pre[E];
        }

        list.add(S);
        sb.append(list.size() + "\n");
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i) + " ");
        }
        System.out.println(sb);
        br.close();
    }

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            super();
            this.idx = idx;
            this.cost = cost;
        }
    }
}
