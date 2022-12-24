package day349;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day320BOJ4913페르마의크리스마스정리 {
    static final int MAX = 1000001;
    static int L, U, x, y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        boolean[] primes = eratos();

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            U = Integer.parseInt(st.nextToken());
            if (L == -1 && U == -1)
                break;
            x = 0;
            y = 0;

            // from 종현
            int tempL = L < 0 ? 0 : L;
            int tempU = U < 0 ? 0 : U;

            // 25%, 시간초과 더러운 문제..
            // for (int i = Math.max(0, L); i <= Math.max(0, U); i++) {
            for (int i = tempL; i <= tempU; i++) {
                if (primes[i]) {
                    x++;
                    if (i % 4 == 1 || i == 2)
                        y++;
                }
            }
            bw.write(L + " " + U + " " + x + " " + y + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // 에라토스테네스의 체
    private static boolean[] eratos() {
        boolean[] res = new boolean[MAX];

        Arrays.fill(res, true);
        res[0] = res[1] = false;

        for (int i = 2; i * i < MAX; i++) {
            for (int j = i * i; j < MAX; j += i) {
                res[j] = false;
            }
        }

        return res;
    }
}
