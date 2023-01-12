package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day339BOJ23843콘센트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> eq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            eq.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < M; i++)
            pq.add(0);

        while (!eq.isEmpty())
            pq.add(eq.poll() + pq.poll());

        while (pq.size() != 1)
            pq.poll();

        System.out.println(pq.poll());
        br.close();
    }
}
