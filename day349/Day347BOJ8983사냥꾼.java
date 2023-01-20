package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day347BOJ8983사냥꾼 {

    static int M, N, L, range[];
    static Animal[] animals;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 사대의 수
        N = Integer.parseInt(st.nextToken()); // 동물의 수
        L = Integer.parseInt(st.nextToken()); // 사정거리
        range = new int[M];
        animals = new Animal[N];

        // 사대 정보
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            range[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            animals[i] = new Animal(a, b);
        }

        System.out.println(process());
    }

    private static int process() {

        int res = 0;
        Arrays.sort(range);

        for (int i = 0; i < N; i++) {
            res += search(i);
        }

        return res;
    }

    private static int search(int idx) {

        int start = 0, end = M, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid >= M)
                return 0;

            int dist = getDist(animals[idx].r, animals[idx].c, range[mid]);
            if (L < dist && animals[idx].r < range[mid])
                end = mid - 1;
            else if (L < dist && animals[idx].r >= range[mid])
                start = mid + 1;
            else if (L >= dist)
                return 1;
        }

        return 0;
    }

    private static int getDist(int a, int b, int x) {
        return Math.abs(x - a) + b;
    }

    static class Animal {
        int r, c;

        public Animal(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
