package day349;

import java.io.*;
import java.util.*;

public class Day342BOJ1939중량제한 {

    static class Node {
        int end;
        int w;

        public Node(int end, int w) {
            this.end = end;
            this.w = w;
        }
    }

    static int N, maxC, maxWeight = 0;
    static ArrayList<Node>[] adjList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());

            adjList[A].add(new Node(B, C));
            adjList[B].add(new Node(A, C));

            maxC = Math.max(C, maxC);
        }

        st = new StringTokenizer(br.readLine());
        int factoryA = Integer.parseInt(st.nextToken()) - 1;
        int factoryB = Integer.parseInt(st.nextToken()) - 1;

        findMaxWeight(factoryA, factoryB);

        System.out.println(maxWeight);
    }

    private static void findMaxWeight(int factoryA, int factoryB) {

        int low = 1;
        int high = maxC;

        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] checked = new boolean[N];

        while (low <= high) {

            int mid = (low + high) / 2;
            q.add(factoryA);
            checked[factoryA] = true;

            boolean existed = existPossibleRoute(q, checked, mid, factoryB);

            if (existed) {
                maxWeight = Math.max(maxWeight, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            q.clear();
            Arrays.fill(checked, false);
        }
    }

    private static boolean existPossibleRoute(Queue<Integer> q, boolean[] checked, int mid, int end) {

        while (!q.isEmpty()) {
            int from = q.poll();

            for (Node v : adjList[from]) {
                if (v.w >= mid) {
                    if (from == end) {
                        return true;
                    }
                    if (!checked[v.end]) {
                        checked[v.end] = true;
                        q.add(v.end);
                    }
                }
            }
        }
        return false;
    }

}
