import java.util.*;
import java.io.*;

public class Day372BOJ2812크게만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String number = br.readLine();
        int last = 0;

        for (int i = 0; i < N - K; i++) {
            int max = -1;
            for (int j = last; j < i + K + 1; j++) {
                int now = number.charAt(j) - '0';
                if (now > max) {
                    max = now;
                    last = j + 1;
                }
                if (max == 9)
                    break;
            }
            sb.append(max);
        }
        System.out.println(sb);
    }
}
