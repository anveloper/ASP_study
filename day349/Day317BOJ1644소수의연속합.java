package day349;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Day317BOJ1644소수의연속합 {
    static boolean prime[];
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        prime = new boolean[N + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!prime[i])
                for (int j = i * i; j <= N; j += i)
                    prime[j] = true;
        }
        for (int i = 1; i <= N; i++) {
            if (!prime[i])
                primes.add(i);
        }

        int l = 0, r = 0, sum = 0, cnt = 0;
        while (true) {
            if (sum >= N)
                sum -= primes.get(l++);
            else if (r == primes.size())
                break;
            else
                sum += primes.get(r++);
            if (N == sum)
                cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}
