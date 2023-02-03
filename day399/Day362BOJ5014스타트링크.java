package day399;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day362BOJ5014스타트링크 {
    static int F, S, G, U, D, ans = -1;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new int[F + 1];

        bfs();

        if (ans >= 0)
            System.out.println(ans);
        else
            System.out.println("use the stairs");
        br.close();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        visited[S] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == G) {
                ans = visited[cur] - 1;
                break;
            }

            if (cur + U <= F) {
                if (visited[cur + U] == 0) {
                    visited[cur + U] += visited[cur] + 1;
                    q.add(cur + U);
                }
            }
            if (cur - D > 0) {
                if (visited[cur - D] == 0) {
                    visited[cur - D] += visited[cur] + 1;
                    q.add(cur - D);
                }
            }
        }
    }
}
