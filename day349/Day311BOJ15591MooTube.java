import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day311BOJ15591MooTube {
    static int N, Q;
    static List<int[]>[] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // 1부터 시작 0번 미사용
        edges = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        // N - 1개 줄 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            edges[p].add(new int[] { q, r });
            edges[q].add(new int[] { p, r });
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            sb.append(bfs(k, v));
        }

        System.out.println(sb);
        br.close();
    }

    static boolean[] visited;
    static Queue<Integer> q;

    private static String bfs(int k, int v) {
        // 초기화
        int ans = 0;
        visited = new boolean[N + 1];
        q = new LinkedList<>();

        visited[v] = true;
        q.add(v);

        while (!q.isEmpty()) {
            int c = q.poll(); // 현재
            for (int[] edge : edges[c]) {
                int n = edge[0]; // 노드
                int r = edge[1]; // 비용
                if (!visited[n] && r >= k) {
                    visited[n] = true;
                    q.add(n);
                    ans++;
                }
            }
        }
        return ans + "\n";
    }
}
