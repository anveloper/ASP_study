import java.io.*;
import java.util.*;

public class Day355BOJ2143두배열의합 {
    static int T, N, M;
    static long ans = 0L;
    static int[] A, B;
    static HashMap<Integer, Integer> map;
    static StringTokenizer st1, st2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        st1 = new StringTokenizer(br.readLine());
        M = Integer.parseInt(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st1.nextToken());
        B = new int[M];
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st2.nextToken());

        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            for (int j = i; j < N; j++) {
                tmp += A[j];
                Integer cnt = map.get(tmp);
                if (cnt == null)
                    map.put(tmp, 1);
                else
                    map.replace(tmp, cnt + 1);
            }
        }

        for (int i = 0; i < M; i++) {
            int tmp = 0;
            for (int j = i; j < M; j++) {
                tmp += B[j];
                int dif = T - tmp;
                Integer cnt = map.get(dif);
                if (cnt != null)
                    ans += cnt;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
