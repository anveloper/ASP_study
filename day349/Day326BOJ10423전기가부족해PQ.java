package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day326BOJ10423전기가부족해PQ {
    static int N, M, K, ans = 0;
    static int[] arr;
    static PriorityQueue<int[]> edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];
        edges = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new int[] { u, v, w });
        }

        kruscal();
        System.out.println(ans);
        br.close();
    }

    // kruscal
    static int[] p;

    private static void kruscal() {
        p = new int[N + 1];
        init();

        for (int i = 0; i < K; i++) {
            p[arr[i]] = -1;
        }

        for (int i = 0; i < M; i++) {
            int[] tmp = edges.poll();
            if (unionSet(tmp[0], tmp[1])) {
                ans += tmp[2];
                if (check()) {
                    break;
                }
            }
        }
    }

    private static boolean check() {
        for (int i = 1; i < N + 1; i++) {
            if (p[i] != -1)
                return false;
        }
        return true;
    }

    private static void init() {
        for (int i = 1; i < N + 1; i++) {
            p[i] = i;
        }
    }

    private static boolean unionSet(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if (a == b)
            return false;
        if (b == -1)
            p[a] = b;
        else
            p[b] = a;
        return true;
    }

    private static int findSet(int a) {
        if (p[a] == -1)
            return -1;
        return p[a] = (a == p[a]) ? a : findSet(p[a]);
    }
}
